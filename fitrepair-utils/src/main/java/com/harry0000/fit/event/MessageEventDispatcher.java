package com.harry0000.fit.event;

import com.harry0000.fit.Header;
import com.harry0000.fit.message.Activity;
import com.harry0000.fit.message.DataMessage;
import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.DeviceInfo;
import com.harry0000.fit.message.DeviceSettings;
import com.harry0000.fit.message.Event;
import com.harry0000.fit.message.FileId;
import com.harry0000.fit.message.Hrv;
import com.harry0000.fit.message.Lap;
import com.harry0000.fit.message.Length;
import com.harry0000.fit.message.Record;
import com.harry0000.fit.message.Session;
import com.harry0000.fit.message.UserProfile;
import com.harry0000.fit.vo.FitMessage;

public class MessageEventDispatcher {

    @FunctionalInterface
    private interface MessageListener<T extends DataMessage> {

        /**
         * @param defMsg
         * @param msg
         */
        void onMessage(final DefinitionMessage defMsg, final T msg);
    }

    private HeaderListener headerLintener;

    private DefinitionMessageListener definitionMsgListener;

    private MessageListener<DataMessage> dataMsgListener;
    private MessageListener<FileId> fileIdListener;
    private MessageListener<DeviceSettings> deviceSettingsListener;
    private MessageListener<UserProfile> userProfileListener;
    private MessageListener<Session> sessionListener;
    private MessageListener<Lap> lapListener;
    private MessageListener<Record> recordListener;
    private MessageListener<Event> eventListener;
    private MessageListener<DeviceInfo> deviceInfoListener;
    private MessageListener<Activity> activityListener;
    private MessageListener<Hrv> hrvListener;
    private MessageListener<Length> lengthListener;

    /**
     * 
     */
    public MessageEventDispatcher() {
    }

    /**
     * @param header
     */
    public void onHeader(final Header header) {
        if (headerLintener != null) {
            headerLintener.onHeader(header);
        }
    }

    /**
     * @param defMsg
     */
    public void onDefinitionMessage(final DefinitionMessage defMsg) {
        if (definitionMsgListener != null) {
            definitionMsgListener.onDefinitionMessage(defMsg);
        }
    }

    /**
     * @param defMsg
     * @param msg
     */
    public void onDataMessage(final DefinitionMessage defMsg, final DataMessage msg) {
        final FitMessage fitMessage = FitMessage.get(defMsg.getFitMessageNumber());
        switch (fitMessage) {
        case FILE_ID:
            dispatch(defMsg, new FileId(msg), fileIdListener);
            break;
        case DEVICE_SETTINGS:
            dispatch(defMsg, new DeviceSettings(msg), deviceSettingsListener);
            break;
        case USER_PROFILE:
            dispatch(defMsg, new UserProfile(msg), userProfileListener);
            break;
        case SESSION:
            dispatch(defMsg, new Session(msg), sessionListener);
            break;
        case LAP:
            dispatch(defMsg, new Lap(msg), lapListener);
            break;
        case RECORD:
            dispatch(defMsg, new Record(msg), recordListener);
            break;
        case EVENT:
            dispatch(defMsg, new Event(msg), eventListener);
            break;
        case DEVICE_INFO:
            dispatch(defMsg, new DeviceInfo(msg), deviceInfoListener);
            break;
        case ACTIVITY:
            dispatch(defMsg, new Activity(msg), activityListener);
            break;
        case HRV:
            dispatch(defMsg, new Hrv(msg), hrvListener);
            break;
        case LENGTH:
            dispatch(defMsg, new Length(msg), lengthListener);
            break;
        default:
            if (dataMsgListener != null) {
                dataMsgListener.onMessage(defMsg, msg);
            }
            break;
        }
    }

    /**
     * @param defMsg
     * @param msg
     * @param listener
     */
    private <T extends DataMessage> void dispatch(final DefinitionMessage defMsg,
                                                  final T msg,
                                                  final MessageListener<T> listener) {
        if (listener != null) {
            listener.onMessage(defMsg, msg);
        } else if (dataMsgListener != null) {
            dataMsgListener.onMessage(defMsg, msg);
        }
    }

    /**
     * 
     */
    public void removeListeners() {
        headerLintener = null;
        definitionMsgListener = null;
        dataMsgListener = null;

        fileIdListener         = null;
        deviceSettingsListener = null;
        userProfileListener    = null;
        sessionListener        = null;
        lapListener            = null;
        recordListener         = null;
        eventListener          = null;
        deviceInfoListener     = null;
        activityListener       = null;
        hrvListener            = null;
        lengthListener         = null;
    }

    /**
     * @param headerLintener the headerLintener to set
     */
    public void setHeaderLintener(final HeaderListener headerLintener) {
        this.headerLintener = headerLintener;
    }

    /**
     * @param definitionMsgListener the definitionMsgListener to set
     */
    public void setDefinitionMsgListener(final DefinitionMessageListener definitionMsgListener) {
        this.definitionMsgListener = definitionMsgListener;
    }

    /**
     * @param dataMsgListener the dataMsgListener to set
     */
    public void setDataMsgListener(final DataMessageListener dataMsgListener) {
        this.dataMsgListener = dataMsgListener != null ?
                                   (defMsg, msg) -> dataMsgListener.onMessage(defMsg, msg) :
                                   null;
    }

    /**
     * @param fileIdListener the fileIdListener to set
     */
    public void setFileIdListener(final FileIdListener fileIdListener) {
        this.fileIdListener = fileIdListener != null ?
                                  (defMsg, msg) -> fileIdListener.onMessage(defMsg, msg) :
                                  null;
    }

    /**
     * @param deviceSettingsListener the deviceSettingsListener to set
     */
    public void setDeviceSettingsListener(final DeviceSettingsListener deviceSettingsListener) {
        this.deviceSettingsListener = deviceSettingsListener != null ?
                                          (defMsg, msg) -> deviceSettingsListener.onMessage(defMsg, msg) :
                                          null;
    }

    /**
     * @param userProfileListener the userProfileListener to set
     */
    public void setUserProfileListener(final UserProfileListener userProfileListener) {
        this.userProfileListener = userProfileListener != null ?
                                       (defMsg, msg) -> userProfileListener.onMessage(defMsg, msg) :
                                       null;
    }

    /**
     * @param sessionListener the sessionListener to set
     */
    public void setSessionListener(final SessionListener sessionListener) {
        this.sessionListener = sessionListener != null ?
                                   (defMsg, msg) -> sessionListener.onMessage(defMsg, msg) :
                                   null;
    }

    /**
     * @param lapListener the lapListener to set
     */
    public void setLapListener(final LapListener lapListener) {
        this.lapListener = lapListener != null ?
                               (defMsg, msg) -> lapListener.onMessage(defMsg, msg) :
                               null;
    }

    /**
     * @param recordListener the recordListener to set
     */
    public void setRecordListener(final RecordListener recordListener) {
        this.recordListener = recordListener != null ?
                                  (defMsg, msg) -> recordListener.onMessage(defMsg, msg) :
                                  null;
    }

    /**
     * @param eventListener the eventListener to set
     */
    public void setEventListener(final EventListener eventListener) {
        this.eventListener = eventListener != null ?
                                 (defMsg, msg) -> eventListener.onMessage(defMsg, msg) :
                                 null;
    }

    /**
     * @param deviceInfoListener the deviceInfoListener to set
     */
    public void setDeviceInfoListener(final DeviceInfoListener deviceInfoListener) {
        this.deviceInfoListener = deviceInfoListener != null ?
                                      (defMsg, msg) -> deviceInfoListener.onMessage(defMsg, msg) :
                                      null;
    }

    /**
     * @param activityListener the activityListener to set
     */
    public void setActivityListener(final ActivityListener activityListener) {
        this.activityListener = activityListener != null ?
                                    (defMsg, msg) -> activityListener.onMessage(defMsg, msg) :
                                    null;
    }

    /**
     * @param hrvListener the hrvListener to set
     */
    public void setHrvListener(final HrvListener hrvListener) {
        this.hrvListener = hrvListener != null ?
                               (defMsg, msg) -> hrvListener.onMessage(defMsg, msg) :
                               null;
    }

    /**
     * @param lengthListener the lengthListener to set
     */
    public void setLengthListener(final LengthListener lengthListener) {
        this.lengthListener = lengthListener != null ?
                                  (defMsg, msg) -> lengthListener.onMessage(defMsg, msg) :
                                  null;
    }

}
