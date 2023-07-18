package com.example.quartzscheduling.quartzJob;
/**
 * @author BAO 7/18/2023
 */
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * mặc dù đánh dấu @Bean và @AUtowired. Quartz Scheduler không biết các phụ thuộc của bean đó và
 * không thể tự động inject. Quartz Scheduler tạo ra các đối tượng công việc (Job) thông qua
 * reflection và không thông qua Spring Framework, vì vậy Spring không kiểm soát đối với quá trình
 * tạo đói tượng này
 *
 * <p>VÌ vậy cần phải sử dụng ApplicationContext để inject
 */
public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory
    implements ApplicationContextAware {

  private transient AutowireCapableBeanFactory beanFactory;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    beanFactory = applicationContext.getAutowireCapableBeanFactory();
  }

  @Override
  protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
    final Object obj = super.createJobInstance(bundle);
    beanFactory.autowireBean(obj);
    return obj;
  }
}
