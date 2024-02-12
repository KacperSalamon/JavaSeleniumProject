package Secanrios;

import Helpers.Sceanrio;
import Tabs.CharactersticsPage;
import Tabs.ProcessesPage;

public class AddNewCharacteristics implements Sceanrio<CharactersticsPage, CharactersticsPage>{


    String processName;
    String characteristicName;
    String lsl;

    String usl;
    String histogram;

    public AddNewCharacteristics(String processName, String characteristicName, String lsl, String usl, String histogram) {
        this.processName = processName;
        this.characteristicName = characteristicName;
        this.lsl = lsl;
        this.usl = usl;
        this.histogram = histogram;
    }

    @Override
    public CharactersticsPage run(CharactersticsPage page) {
        return page
                .selectProcess(processName)
                .provideName(characteristicName)
                .provideLowerLimit(lsl)
                .provideUpperLimit(usl)
                .provideHistogram(histogram);

    }


}
