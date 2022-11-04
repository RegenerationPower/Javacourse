/*
Тема:  Класи в мові програмування Java.

        Мета:  Ознайомлення з класами. Використання існуючих та створення власних класів в мові Java.

        Завдання

        Визначити C11як остачу від ділення номера залікової книжки студента на 11
        В залежності від C11 визначити варіант завдання:
        C11 	Варіант завдання
        0 	Визначити клас студент, який складається як мінімум з 5-и полів.
        1 	Визначити клас навчальний заклад, який складається як мінімум з 5-и полів.
        2 	Визначити клас автомобіль, який складається як мінімум з 5-и полів.
        3 	Визначити клас літак, який складається як мінімум з 5-и полів.
        4 	Визначити клас морський човен, який складається як мінімум з 5-и полів.
        5 	Визначити клас одяг, який складається як мінімум з 5-и полів.
        6 	Визначити клас косметика, який складається як мінімум з 5-и полів.
        7 	Визначити клас спортивний інвентар, який складається як мінімум з 5-и полів.
        8 	Визначити клас меблі, який складається як мінімум з 5-и полів.
        9 	Визначити клас студент, який складається як мінімум з 5-и полів.
        10 	Визначити клас студент, який складається як мінімум з 5-и полів.
        Створити клас із виконавчим методом, в якому створити масив з об’єктів класу визначеному варіантом (п. 2).
        Відсортувати масив, за одним з полів, за зростанням, а за іншим, за спаданням використавши при цьому стандартні засоби сортування.
        Всі змінні повинні бути описані та значення їх задані у виконавчому методі. Код повиненвідповідати стандартам JCC та бути детально задокументований.

Лаб 4
Виконав студент групи ІО-04 Возниця Дмитро 0403
Варіант:
C11=7(Визначити клас спортивний інвентар, який складається як мінімум з 5-и полів.)
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<SportInventory> inventoryList = new ArrayList<>();
        SportInventory ball = new SportInventory("ball", "black", 50, 2.6, true);
        SportInventory gloves = new SportInventory("gloves", "blue", 35, 0.2, true);
        inventoryList.add(ball);
        inventoryList.add(gloves);
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("\nEnter number of sport inventories: ");
        int number = scanner.nextInt();
        scanner.nextLine();

                for (int i = 0; i < number; i++) {

                    System.out.println("Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Color: ");
                    String color = scanner.nextLine();

                    System.out.println("Cost: ");
                    int cost = scanner.nextInt();

                    System.out.println("Weight: ");
                    double weight = scanner.nextDouble();

                    System.out.println("Available: ");
                    Boolean available= scanner.nextBoolean();
                    scanner.nextLine();

                    SportInventory inventoryAdd = new SportInventory(name, color, cost, weight, available);
                    inventoryList.add(inventoryAdd);
                }
        }
        catch (Exception e){
            System.out.println("Incorrect input");
        }


        System.out.println("\nAll inventory: ");
        for(SportInventory student:inventoryList){
            System.out.println(student.toString());
        }

        System.out.println("\nSorted by name: ");
        inventoryList.sort(SportInventory.sortByName());
        for(SportInventory student:inventoryList){
            System.out.println(student.toString());
        }

        System.out.println("\nSorted by cost: ");
        inventoryList.sort(SportInventory.sortByCost());
        for(SportInventory student:inventoryList){
            System.out.println(student.toString());
        }

        System.out.println("\nSorted by weight: ");
        inventoryList.sort(SportInventory.sortByWeight());
        for(SportInventory student:inventoryList){
            System.out.println(student.toString());
        }
    }
}