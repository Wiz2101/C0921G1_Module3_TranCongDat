package repository;

import bean.*;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailRepository {
    public void createContractDetail(ContractDetail contractDetail) throws SQLException;
    public List<ContractDetail> displayAllContractDetail();
    public List<Contract> selectAllContract();
    public List<AttachService> selectAttachService();
}
