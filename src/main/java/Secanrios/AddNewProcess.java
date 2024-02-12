package Secanrios;

import Helpers.Sceanrio;
import Tabs.ProcessesPage;
import Tabs.RegisterPage;

public class AddNewProcess implements Sceanrio<ProcessesPage, ProcessesPage>{

    String name;
    String description;

    String notes;

    public AddNewProcess(String name, String description, String notes) {
        this.name = name;
        this.description = description;
        this.notes = notes;
    }

    @Override
    public ProcessesPage run(ProcessesPage page) {
        return page
                .name(name)
                .description(description)
                .notes(notes);
    }


}
