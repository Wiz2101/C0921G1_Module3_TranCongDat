package repository.impl;

import bean.*;
import repository.IContractDetailRepository;
import repository.IContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {

    private static final String SELECT_ALL_CONTRACT_DETAIL_SQL = "SELECT * FROM contract_detail JOIN contract ON contract_detail.contract_id = contract.contract_id JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id WHERE contract_detail_status = 1";
    private static final String SELECT_CONTRACT_SQL = "SELECT * FROM contract";
    private static final String SELECT_ATTACH_SERVICE_SQL = "SELECT * FROM attach_service";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "INSERT INTO contract_detail (contract_id,attach_service_id,quantity) VALUES (?,?,?)";


    @Override
    public void createContractDetail(ContractDetail contractDetail) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_CONTRACT_DETAIL_SQL);
            preparedStatement.setInt(1, contractDetail.getContract().getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachService().getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuality());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<ContractDetail> displayAllContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_CONTRACT_DETAIL_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contractDetailList.add(new ContractDetail(rs.getInt("contract_detail_id"),new Contract(rs.getInt("contract_id")),new AttachService(rs.getInt("attach_service_id"),rs.getString("attach_service_name")),rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetailList;
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CONTRACT_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contractList.add(new Contract(rs.getInt("contract_id")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractList;
    }

    @Override
    public List<AttachService> selectAttachService() {
        List<AttachService> attachServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ATTACH_SERVICE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                attachServiceList.add(new AttachService(rs.getInt("attach_service_id"), rs.getString("attach_service_name")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return attachServiceList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}