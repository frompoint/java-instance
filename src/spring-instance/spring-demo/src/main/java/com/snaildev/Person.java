package com.snaildev;

public class Person {
    private IHelloMessage iHelloMessage;

    /**
     * @return
     */
    public IHelloMessage getiHelloMessage() {
        return iHelloMessage;
    }

    /**
     * @param iHelloMessage
     */
    public void setiHelloMessage(IHelloMessage iHelloMessage) {
        this.iHelloMessage = iHelloMessage;
    }


    /**
     * @return
     */
    public String sayHello() {
        return this.iHelloMessage.sayHello();
    }
}
