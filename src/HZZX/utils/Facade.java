package HZZX.utils;

import HZZX.View.SQLserver;

public class Facade {

    SQLserver s = new SQLserver();

    //登录成功与否的验证
    public void SQLverify1(String a, String b) {
        s.SQLverify1(a, b);
    }

    //客户登录与否验证
    public void SQLverify2(String a, String b) {
        s.SQLverify2(a, b);
    }

    //是否注册成功
    public void zhuceverify1(String a) {
        s.ZhuceVerify1(a);
    }

}