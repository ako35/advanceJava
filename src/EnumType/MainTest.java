package EnumType;
public class MainTest {
    public static void main(String[] args) {
        useConstantMethod(1);
        useConstantMethod(2);
        useConstantMethod(3);
        useConstantMethod(4);
        useConstantMethod(100);
        useConstantMethod(5);
        System.out.println();
        useEnumMethod(TransactionType.DEPOSIT);
        useEnumMethod(TransactionType.PAYMENT);
        useEnumMethod(TransactionType.WITHDRAW);
        useEnumMethod(TransactionType.TRANSFER);
        useEnumMethod(TransactionType.OTHER);
    }
    private static void useConstantMethod(int i){
        if (i==TransactionTypeConstant.DEPOSIT){
            System.out.println("money is depositing");
        } else if (i==TransactionTypeConstant.WITHDRAW){
            System.out.println("money is withdrawing");
        } else if (i==TransactionTypeConstant.TRANSFER){
            System.out.println("money is transfering");
        } else if (i==TransactionTypeConstant.PAYMENT){
            System.out.println("money is being made");
        } else if (i==TransactionTypeConstant.OTHER){
            System.out.println("other transaction");
        }
    }
    private static void useEnumMethod(TransactionType transactionType){
        if (transactionType==TransactionType.DEPOSIT){
            System.out.println("money is depositing");
        } else if (transactionType==TransactionType.WITHDRAW){
            System.out.println("money is withdrawing");
        } else if (transactionType==TransactionType.TRANSFER){
            System.out.println("money is transfering");
        } else if (transactionType==TransactionType.PAYMENT){
            System.out.println("money is being made");
        } else if (transactionType==TransactionType.OTHER){
            System.out.println("other transaction");
        }
    }
}
