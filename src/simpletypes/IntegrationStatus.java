package simpletypes;

public enum IntegrationStatus {
    SAVED, // file saved in register
    READY, // saved as To_DO file
    RUNNING, // currently used by a thread
    COMPLETED, // DONE - moved and integrated
    UNCOMPLETED, // Something goes wrong
    ABORTED // Argument send by user in console
}
