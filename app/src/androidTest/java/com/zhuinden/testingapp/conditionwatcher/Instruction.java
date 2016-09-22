package com.zhuinden.testingapp.conditionwatcher;

import android.os.Bundle;

/**
 * Created by F1sherKK on 16/12/15.
 * https://github.com/AzimoLabs/ConditionWatcher/blob/master/conditionwatcher/src/main/java/com/azimolabs/conditionwatcher/ConditionWatcher.java
 */
public abstract class Instruction {

    private Bundle dataContainer = new Bundle();

    public final void setData(Bundle dataContainer) {
        this.dataContainer = dataContainer;
    }

    public final Bundle getDataContainer() {
        return dataContainer;
    }

    public abstract String getDescription();

    public abstract boolean checkCondition();
}