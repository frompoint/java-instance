public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        String input = "1+2*4/5-7+3/6";

        InToPost theTrans = new InToPost(input);
        String output = theTrans.doTrans();

        System.out.println("Postfix is " + output + '\n');

        StringReverserThroughStack theReverser = new StringReverserThroughStack(input);
        output = theReverser.doRev();
        System.out.println("反转前： " + input);
        System.out.println("反转后： " + output);
    }
}
