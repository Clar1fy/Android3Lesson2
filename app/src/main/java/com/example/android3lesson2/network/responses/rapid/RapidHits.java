package com.example.android3lesson2.network.responses.rapid;

import com.google.gson.annotations.SerializedName;

public class RapidHits {
    @SerializedName("id")
    private String id;
    @SerializedName("segment")
    private String segment;
    @SerializedName("translation")
    private String translation;
    @SerializedName("source")
    private String source;
    @SerializedName("target")
    private String target;
    @SerializedName("quality")
    private String quality;
    @SerializedName("reference")
    private Object reference;
    @SerializedName("usage-count")
    private Integer usageCount;
    @SerializedName("subject")
    private String subject;
    @SerializedName("created-by")
    private String createdBy;
    @SerializedName("last-updated-by")
    private String lastUpdatedBy;
    @SerializedName("create-date")
    private String createDate;
    @SerializedName("last-update-date")
    private String lastUpdateDate;
    @SerializedName("match")
    private Integer match;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }


    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }
}
