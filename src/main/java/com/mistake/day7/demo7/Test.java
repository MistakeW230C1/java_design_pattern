package com.mistake.day7.demo7;

public class Test {
    public static void main(String[] args) {
        IRegist email = new fromEmail();
        CountInvoke emailInvoke = new CountInvoke(email);
        IRegist emailProxy = (IRegist) GenericProxy.creatProxy(email, emailInvoke);
        emailProxy.regist("email");
        System.out.println(emailInvoke.getCount());

        IRegist post = new fromPost();
        CountInvoke postInvoke = new CountInvoke(post);
        IRegist postProxy = (IRegist) GenericProxy.creatProxy(post, postInvoke);
        postProxy.regist("post");
        System.out.println(postInvoke.getCount());
    }
}
