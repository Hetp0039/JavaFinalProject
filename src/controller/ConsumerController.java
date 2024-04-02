package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.ConsumerDao;
import model.Consumer;

public class ConsumerController {
    private final ConsumerDao consumerDao;
    private final Scanner scanner;

    public ConsumerController(ConsumerDao consumerDao, Scanner scanner) {
        this.consumerDao = consumerDao;
        this.scanner = scanner;
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

    public void manageConsumers() {
        System.out.println("Consumer Management");
        System.out.println("1. Register New Consumer");
        System.out.println("2. Update Consumer");
        System.out.println("3. Delete Consumer");
        System.out.println("4. View All Consumers");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerConsumerMenu();
                break;
            case 2:
                updateConsumerMenu();
                break;
            case 3:
                deleteConsumerMenu();
                break;
            case 4:
                viewAllConsumers();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageConsumers();
                break;
        }
    }

    private void registerConsumerMenu() {
        // Logic for registering a new consumer
    }

    private void updateConsumerMenu() {
        // Logic for updating a consumer
    }

    private void deleteConsumerMenu() {
        // Logic for deleting a consumer
    }

    private void viewAllConsumers() {
        List<Consumer> consumers = getAllConsumers();
        // Display all consumers
    }
}
