package com.festec.example.generators;

import com.example.annotations.EntryGenerator;
import com.example.latte.wechat.templates.WXEntryTemplate;

/**
 * Created by 25400 on 2020/4/6.
 */

@EntryGenerator(
        packageName = "com.example.festec",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
