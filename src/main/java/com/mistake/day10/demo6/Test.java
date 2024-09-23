package com.mistake.day10.demo6;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Msgsrc src = new Msgsrc();
        ShowReceive rvr = new ShowReceive();
        EmailReceive rvr2 = new EmailReceive();

        Command com = new Command(rvr,src);
        Command com2 = new Command(rvr2,src);

        CommandMange mange = new CommandMange(src);
        mange.addCommand(com);
        mange.addCommand(com2);
        mange.start();

        String  s [] ={"li:aa","zhang:hh","wang:xx","zhang:11"};
        for (int i = 0; i < s.length; i++) {
            src.come(s[i]);
            Thread.sleep(1000);
        }
        mange.bMark =false;
    }

}
