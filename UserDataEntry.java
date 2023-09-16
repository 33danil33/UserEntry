import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserDataEntry {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в произвольном порядке (Фамилия Имя Отчество дата рождения номер телефона пол):");
            String input = scanner.nextLine();
            
            String[] data = input.split(" ");
            
            if (data.length != 6) {
                System.err.println("Ошибка: Необходимо ввести 6 параметров.");
                return;
            }
            
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String dob = data[3];
            long phoneNumber;
            char gender;
            
            try {
                phoneNumber = Long.parseLong(data[4]);
                gender = data[5].charAt(0);
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                System.err.println("Ошибка: Неверный формат данных.");
                return;
            }
            
            String fileName = lastName + ".txt";
            
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                String userData = lastName + firstName + middleName + " " + dob + " " + phoneNumber + gender;
                fileWriter.write(userData);
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: Неверный формат ввода.");
        }
    }
}