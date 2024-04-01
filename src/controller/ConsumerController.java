 package controller;

 import java.util.List;

import dataaccesslayer.ConsumerDao;
import model.Consumer;

 public class ConsumerController {
     private final ConsumerDao consumerDao;

     public ConsumerController(ConsumerDao consumerDao) {
         this.consumerDao = consumerDao;
     }

     public void registerConsumer(Consumer consumer) {
         consumerDao.save(consumer);
     }

     public Consumer getConsumerByEmail(String email) {
         return consumerDao.getConsumerByEmail(email);
     }

     public void updateConsumer(Consumer consumer) {
         consumerDao.update(consumer);
     }

     public void deleteConsumer(int consumerId) {
         consumerDao.delete(consumerId);
     }

     public List<Consumer> getAllConsumers() {
         return consumerDao.getAllConsumers();
     }
 }

