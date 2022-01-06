package service.impl;

import bean.AttachService;
import bean.Contract;
import bean.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.ContractDetailRepository;
import service.IContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailService implements IContractDetailService {
    IContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public void createContractDetail(ContractDetail contractDetail) throws SQLException {
        this.contractDetailRepository.createContractDetail(contractDetail);
    }

    @Override
    public List<ContractDetail> displayAllContractDetail() {
        return this.contractDetailRepository.displayAllContractDetail();
    }

    @Override
    public List<Contract> selectAllContract() {
        return this.contractDetailRepository.selectAllContract();
    }

    @Override
    public List<AttachService> selectAttachService() {
        return this.contractDetailRepository.selectAttachService();
    }
}
