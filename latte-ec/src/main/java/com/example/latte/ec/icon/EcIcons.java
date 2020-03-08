package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by 25400 on 2020/3/1.
 */

public enum EcIcons implements Icon{
    icon_scon('\ue694'),
    icon_ali_pay('\ue694');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
