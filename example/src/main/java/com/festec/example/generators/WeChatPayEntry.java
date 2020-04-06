package com.festec.example.generators;

import com.example.annotations.PayEntryGenerator;
import com.example.latte.wechat.templates.WXEntryTemplate;
import com.example.latte.wechat.templates.WXPayEntryTemplate;

/**
 * Created by 25400 on 2020/4/6.
 */

@PayEntryGenerator(
        packageName = "com.example.festec",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
