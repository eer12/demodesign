package cn.com.polycis.modules.analysis.entity;

public class AnalysisParameter {

    private Integer id;

    private Integer analysisId;

    private Integer parameterIndex;
    private Integer type;

    private String parameterKey;

    private Integer dataLength;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
    }

    public Integer getParameterIndex() {
        return parameterIndex;
    }

    public void setParameterIndex(Integer parameterIndex) {
        this.parameterIndex = parameterIndex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParameterKey() {
        return parameterKey;
    }

    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    @Override
    public String toString() {
        return "AnalysisParameter{" +
                "id=" + id +
                ", analysisId=" + analysisId +
                ", parameterIndex=" + parameterIndex +
                ", type=" + type +
                ", parameterKey='" + parameterKey + '\'' +
                ", dataLength=" + dataLength +
                ", description='" + description + '\'' +
                '}';
    }
}
