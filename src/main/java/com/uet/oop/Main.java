package com.uet.oop;

import com.uet.oop.dao.DictionaryDAO;
import com.uet.oop.model.Dictionary;
import com.uet.oop.view.OopGameApplication;
import com.uet.oop.view.commandline.CmdApplication;
import com.uet.oop.view.ui.UiApplication;

public class Main {

    public static void main(String[] args) {
        OopGameApplication application = new CmdApplication();
//        OopGameApplication application = new UiApplication();
//        application.runApplication();
        Dictionary dictionary1 = new Dictionary("a aa", "tes4t");
        DictionaryDAO.getInstance().delete(dictionary1);
    }

}
