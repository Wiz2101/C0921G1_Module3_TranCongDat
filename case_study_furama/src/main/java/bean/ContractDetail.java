package bean;

public class ContractDetail {
    int contractDetailId;
    Contract contract;
    AttachService attachService;
    int quality;

    public ContractDetail() {
    }

    public ContractDetail(Contract contract, AttachService attachService, int quality) {
        this.contract = contract;
        this.attachService = attachService;
        this.quality = quality;
    }

    public ContractDetail(int contractDetailId, Contract contract, AttachService attachService, int quality) {
        this.contractDetailId = contractDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quality = quality;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
