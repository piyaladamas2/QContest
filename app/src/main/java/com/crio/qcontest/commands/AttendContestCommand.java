package com.crio.qcontest.commands;

import java.util.List;

import com.crio.qcontest.entities.Contestant;
import com.crio.qcontest.services.ContestService;

public class AttendContestCommand implements ICommand {

    private final ContestService contestService;

    public AttendContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
    }
}
