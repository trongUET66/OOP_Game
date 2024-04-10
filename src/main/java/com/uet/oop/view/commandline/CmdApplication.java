package com.uet.oop.view.commandline;

import com.uet.oop.Management.FakeDictionaryManagement;
import com.uet.oop.view.OopGameApplication;

public class CmdApplication implements OopGameApplication {

    @Override
    public void runApplication() {
        DictionaryCommandLine commandLine = new DictionaryCommandLine(new FakeDictionaryManagement());
        commandLine.runApp();
    }

}
