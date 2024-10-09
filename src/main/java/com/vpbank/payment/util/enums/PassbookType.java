package com.vpbank.payment.util.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public enum PassbookType {
    TRANSACTION_ACCOUNT {
        @Override
        public String toString() {
            return "TRANSACTION_ACCOUNT";
        }
    },
    PASSBOOK {
        @Override
        public String toString() {
            return "PASSBOOK";
        }
    }
}
