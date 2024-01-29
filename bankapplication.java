import java.util.Scanner;

public class bankapplication {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите логин:");
        String name=sc.nextLine();
        System.out.println("Введите пароль:");
        String customerId=sc.nextLine();
        BankAccount obj1=new BankAccount(name,customerId);
        obj1.menu();
    }
}

class BankAccount{
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName,String customerId){
        this.customerName=customerName;
        this.customerId=customerId;
    }


    void deposit(double amt){
        if(amt!=0){
            bal+=amt;
            prevTrans=amt;
        }
    }

    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
        }
        else if(bal<amt){
            System.out.println("Недостаточно средств для выполнения операции");
        }
    }

    void getPreviousTrans(){
        if(prevTrans>0){
            System.out.println("Внесено: "+prevTrans);
        }
        else if(prevTrans<0){
            System.out.println("Снято: "+Math.abs(prevTrans));
        }
        else{
            System.out.println("Нет прошлых транзакций");
        }
    }

    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Здравствуйте, "+customerName);
        System.out.println("Ваш пароль :"+customerId);
        System.out.println("\n");
        System.out.println("Для выполнения операции нажмите соответствующую цифру:");
        System.out.println("1) Проверить баланс");
        System.out.println("2) Внести деньги");
        System.out.println("3) Снять деньги");
        System.out.println("4) Информация о прошлых транзакциях");
        System.out.println("0) Завершить обслуживание");

        do{
            System.out.println("********************************************");
            System.out.println("Выберите операцию");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case '1':
                    System.out.println("......................");
                    System.out.println("Ваш баланс ="+bal);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case '2':
                    System.out.println("......................");
                    System.out.println("Внесите сумму для депозита:");
                    System.out.println("......................");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case '3':
                    System.out.println("......................");
                    System.out.println("Введите сумму для снятия:");
                    System.out.println("......................");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case '4':
                    System.out.println("......................");
                    System.out.println("Информация о прошлых транзакциях:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case '0':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Ошибка в выборе опции");
                    break;
            }

        }while(option!='0');

        System.out.println("Спасибо! До скорой встречи!");
    }

}