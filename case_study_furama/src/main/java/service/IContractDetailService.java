package service;

import bean.AttachService;
import bean.Contract;
import bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailService {
    public void createContractDetail(ContractDetail contractDetail) throws SQLException;
    public List<ContractDetail> displayAllContractDetail();
    public List<Contract> selectAllContract();
    public List<AttachService> selectAttachService();
}
