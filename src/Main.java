

import java.io.IOException;

public class Main {

    private IOService ioService;
    private MyList myList;

    public Main() {

        this.ioService = new IOServiceImpl();
        this.myList=new MyList();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        ioService.write("Приветствуем Вас!!!");
        operationChoose();
    }

    private void operationChoose() {
        ioService.write("Выберите действие:");
        ioService.write("Наберите 1 для добавления элемента в список");
        ioService.write("Наберите 2 для удаления элемента из списка");
        ioService.write("Наберите 3 для показа содержимого списка");
        ioService.write("Наберите 4 для проверки есть ли содержимое в списке");
        ioService.write("Наберите 5 для замены значения в списке");
        ioService.write("Введите 'exit' для выхода");
        Integer operation = readOperation();
        switch (operation) {
            case 0:


                break;
            case 1:
                // вывести сообщение
                ioService.write("Введите целое число для добавления в список");
                // прочитать значение числа из консоли в переменну
                // прочитанное значение передать в MyList
                myList.add(ioService.readInt());
                ifExit();

                break;
            case 2:
                ioService.write("Введите число для удаления:");
                myList.remove(ioService.readInt());
                ifExit();

                break;
            case 3:
                ioService.write("Содержимое списка:");
                ioService.write(myList.print());
                ifExit();

                break;
            case 4:
                ioService.write("Введите число для проверки:");
                boolean inList = myList.contains(ioService.readInt());
                if (inList) {
                    ioService.write("Число есть в списке");
                } else {
                    ioService.write("Числа нет в списке");
                }
                ifExit();

                break;
            case 5:
                ioService.write("Введите старое число для замены:");
                Integer oldNumber = ioService.readInt();
                ioService.write("Введите новое число:");
                Integer newNumber = ioService.readInt();
                myList.replace(oldNumber, newNumber);
                ifExit();

                break;

        }
    }







    private void ifExit() {
        ioService.write("Желаете ли продолжить? y/n");
        try {
            if (ioService.read().equals("y")) {
                operationChoose();
            }
        } catch (IOException e) {

            ifExit();
        }
    }

    private int readOperation() {
        String operation;
        try {
            if (!(operation = ioService.read()).equals("exit")) {
                Integer operationNumber = Integer.parseInt(operation);
                return operationNumber;
            }
        } catch (IOException e) {

            readOperation();
        }
        return 0;
    }
}
