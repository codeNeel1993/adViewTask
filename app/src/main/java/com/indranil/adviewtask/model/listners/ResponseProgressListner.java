package com.indranil.adviewtask.model.listners;


import com.indranil.adviewtask.model.constants.FailureCodes;

public interface ResponseProgressListner<T> {

        void onResponseInProgress();

        void onResponseCompleted(T response);

        void onResponseFailed(FailureCodes code);
}
