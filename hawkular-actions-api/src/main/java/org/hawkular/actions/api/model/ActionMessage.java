/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.actions.api.model;

import java.util.Map;

import com.google.gson.annotations.Expose;
import org.hawkular.alerts.api.model.condition.Alert;
import org.hawkular.bus.common.BasicMessage;

/**
 * A action message generated from the alerts engine through alert-bus subsystem.
 * Action plugins must listen per actionPlugin of message in the filter.
 *
 * @author Jay Shaughnessy
 * @author Lucas Ponce
 */
public class ActionMessage extends BasicMessage {

    @Expose
    String tenantId;

    @Expose
    String actionPlugin;

    @Expose
    String actionId;

    @Expose
    String message;

    @Expose
    Alert alert;

    @Expose
    Map<String, String> properties;

    public ActionMessage() { }

    public ActionMessage(String tenantId, String actionPlugin, String actionId, String message, Alert alert) {
        this.tenantId = tenantId;
        this.actionPlugin = actionPlugin;
        this.actionId = actionId;
        this.message = message;
        this.alert = alert;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getActionPlugin() {
        return actionPlugin;
    }

    public void setActionPlugin(String actionPlugin) {
        this.actionPlugin = actionPlugin;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionMessage that = (ActionMessage) o;

        if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) return false;
        if (actionPlugin != null ? !actionPlugin.equals(that.actionPlugin) : that.actionPlugin != null) return false;
        return !(actionId != null ? !actionId.equals(that.actionId) : that.actionId != null);

    }

    @Override
    public int hashCode() {
        int result = tenantId != null ? tenantId.hashCode() : 0;
        result = 31 * result + (actionPlugin != null ? actionPlugin.hashCode() : 0);
        result = 31 * result + (actionId != null ? actionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionMessage{" +
                "tenantId='" + tenantId + '\'' +
                ", actionPlugin='" + actionPlugin + '\'' +
                ", actionId='" + actionId + '\'' +
                ", message='" + message + '\'' +
                ", alert=" + alert +
                ", properties=" + properties +
                '}';
    }
}
