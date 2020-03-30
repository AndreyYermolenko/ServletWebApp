package org.example.controller.processors;


import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor {
    public ProcessorLogOut() {
        action = "logOut";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ProcessorResult("/welcome", "", false);
    }
}
