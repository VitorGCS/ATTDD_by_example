package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

public class FirstLightSwitchingCrossingController {

    LightState firstState;
    LightState secondState;

    public void setFirstLight(LightState state){
        firstState = state;
    }
    public void setSecondLight(LightState state){
        secondState = state;
    }

    public LightState firstLight(){
        return firstState;
    }

    public LightState secondLight() {
        return secondState;
    }

    public void execute(){
        if(!isValidLightStateConfiguration()){
            warningConfiguration();
            return;
        }
        firstState = firstState.next();
    }

    private boolean isValidLightStateConfiguration() {
        return LightState.RED.equals(secondState);
    }

    private void warningConfiguration() {
        firstState = LightState.UNKNOWN;
        secondState = LightState.UNKNOWN;
    }

}
