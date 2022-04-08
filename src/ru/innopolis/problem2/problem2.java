public class Main{
    public static void main(String[] args) {
        Broker broker = new Broker();
        Receiver r = new Receiver();
        Buy buy1 = new Buy(r, 5);
        Buy buy2 = new Buy(r, 2);
        Sell sell = new Sell(r, 7);
        broker.setCommand(buy1);
        broker.executeCommand();
        broker.setCommand(buy2);
        broker.executeCommand();
        broker.setCommand(sell);
        broker.executeCommand();
    }
}
class Broker{
    private  Command command;
    public void setCommand(Command c){
        command = c;
    }
    public void executeCommand(){
        command.execute();
    }
}
interface Command{
    public void execute();
}
class Buy implements Command{
     private Receiver receiver;
     private int amount;
     public Buy(Receiver r, int a){
        receiver=r;
        amount = a;
     }
     @Override
     public void execute() {
         receiver.buyMarket(amount);
     }
}
class Sell implements Command{
    private Receiver receiver;
    private int amount;
    public Sell(Receiver r, int a ){
        receiver = r;
        amount = a;
    }
    @Override
    public void execute() {
        receiver.sellMarket(amount);
    }
}
class Receiver {
    public void buyMarket(int amount){
        System.out.println("You have bought "+ amount + " stocks for current market price");
    }
    public void sellMarket(int amount){
        System.out.println("You have sold "+ amount + " stocks for current market price");
    }
}
