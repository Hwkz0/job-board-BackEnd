package com.application.jobboard.ongoing.controller.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ActiveInfo {

    @NotNull
    private long userId;

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @NotNull
    private String userPhone;

    @NotNull
    private long companyId;

    @NotNull
    private String companyName;

    @NotNull
    private String companyAddress;

    @NotNull
    private String companyPhone;

    private String companyRequest;

    @NotNull
    private List<ActiveInfo> ongoingJob;

    @NotNull
    private long jobPay;


    @Builder
    public ActiveInfo(@JsonProperty("userId") long userId, @JsonProperty("userFirstName") String userFirstName, @JsonProperty("userLastName") String userLastName, @JsonProperty("userPhone") String userPhone, @JsonProperty("companyId") long companyId, @JsonProperty("companyName") String companyName, @JsonProperty("companyAddress") String companyAddress, @JsonProperty("companyPhone") String companyPhone, @JsonProperty("companyRequest") String companyRequest, @JsonProperty("ongoingJob") List<ActiveInfo> ongoingJob, @JsonProperty("jobPay") long jobPay) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.companyRequest = companyRequest;
        this.ongoingJob = ongoingJob;
        this.jobPay = jobPay;
    }


}
