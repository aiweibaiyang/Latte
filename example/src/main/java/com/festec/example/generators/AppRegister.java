package com.festec.example.generators;


import com.example.annotations.AppRegisterGenerator;
import com.example.latte.wechat.templates.AppRegisterTemplate;

/**
 * Created by 25400 on 2020/4/6.
 */


@AppRegisterGenerator(
        packageName = "com.example.festec",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
