package com.hilquiascamelo.strproducer.util;

import java.time.LocalDateTime;

public interface HasDateField {
    LocalDateTime getDate();
    void setDate( LocalDateTime date);
}
