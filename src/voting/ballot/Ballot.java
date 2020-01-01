package voting.ballot;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Ballot extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051610a3a380380610a3a8339818101604052602081101561003357600080fd5b810190808051604051939291908464010000000082111561005357600080fd5b90830190602082018581111561006857600080fd5b825186602082028301116401000000008211171561008557600080fd5b82525081516020918201928201910280838360005b838110156100b257818101518382015260200161009a565b50505050919091016040908152600280546001600160a01b0319163317908190556000805460ff191660019081178255885181556001600160a01b0392909216815260036020529182205593505050505b8151811015610165576004604051806040016040528084848151811061012557fe5b6020908102919091018101518252600091810182905283546001818101865594835291819020835160029093020191825591909101519082015501610103565b50506108c4806101766000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c80635c19a95c116100715780635c19a95c14610149578063609ff1bd1461016f57806387351813146101775780639e7b8d6114610193578063a3ec138d146101b9578063e2ba53f01461020d576100a9565b80630121b93f146100ae578063013cf08b146100cd5780632e4176cf146101035780633447d0d11461012757806343d726d614610141575b600080fd5b6100cb600480360360208110156100c457600080fd5b5035610215565b005b6100ea600480360360208110156100e357600080fd5b5035610350565b6040805192835260208301919091528051918290030190f35b61010b61037b565b604080516001600160a01b039092168252519081900360200190f35b61012f61038a565b60408051918252519081900360200190f35b6100cb610390565b6100cb6004803603602081101561015f57600080fd5b50356001600160a01b03166103e5565b61012f610625565b61017f61068c565b604080519115158252519081900360200190f35b6100cb600480360360208110156101a957600080fd5b50356001600160a01b0316610695565b6101df600480360360208110156101cf57600080fd5b50356001600160a01b03166107e1565b6040805194855292151560208501526001600160a01b03909116838301526060830152519081900360800190f35b61012f610816565b60005460ff161515600114610267576040805162461bcd60e51b815260206004820152601360248201527222b632b1ba34b7b71034b99031b637b9b2b21760691b604482015290519081900360640190fd5b33600090815260036020526040902080546102c0576040805162461bcd60e51b8152602060048201526014602482015273486173206e6f20726967687420746f20766f746560601b604482015290519081900360640190fd5b600181015460ff161561030b576040805162461bcd60e51b815260206004820152600e60248201526d20b63932b0b23c903b37ba32b21760911b604482015290519081900360640190fd5b6001818101805460ff19169091179055600281018290558054600480548490811061033257fe5b60009182526020909120600160029092020101805490910190555050565b6004818154811061035d57fe5b60009182526020909120600290910201805460019091015490915082565b6002546001600160a01b031681565b60015481565b6002546001600160a01b031633146103d95760405162461bcd60e51b81526004018080602001828103825260248152602001806108446024913960400191505060405180910390fd5b6000805460ff19169055565b336000908152600360205260408120905460ff161515600114610445576040805162461bcd60e51b815260206004820152601360248201527222b632b1ba34b7b71034b99031b637b9b2b21760691b604482015290519081900360640190fd5b600181015460ff1615610494576040805162461bcd60e51b81526020600482015260126024820152712cb7ba9030b63932b0b23c903b37ba32b21760711b604482015290519081900360640190fd5b6001600160a01b0382163314156104f2576040805162461bcd60e51b815260206004820152601e60248201527f53656c662d64656c65676174696f6e20697320646973616c6c6f7765642e0000604482015290519081900360640190fd5b6001600160a01b038281166000908152600360205260409020600101546101009004161561059a576001600160a01b0391821660009081526003602052604090206001015461010090049091169033821415610595576040805162461bcd60e51b815260206004820152601960248201527f466f756e64206c6f6f7020696e2064656c65676174696f6e2e00000000000000604482015290519081900360640190fd5b6104f2565b6001818101805460ff19168217610100600160a81b0319166101006001600160a01b0386169081029190911790915560009081526003602052604090209081015460ff161561061857816000015460048260020154815481106105f957fe5b6000918252602090912060016002909202010180549091019055610620565b815481540181555b505050565b600080805b60045481101561068757816004828154811061064257fe5b906000526020600020906002020160010154111561067f576004818154811061066757fe5b90600052602060002090600202016001015491508092505b60010161062a565b505090565b60005460ff1681565b60005460ff1615156001146106e7576040805162461bcd60e51b815260206004820152601360248201527222b632b1ba34b7b71034b99031b637b9b2b21760691b604482015290519081900360640190fd5b6002546001600160a01b031633146107305760405162461bcd60e51b81526004018080602001828103825260288152602001806108686028913960400191505060405180910390fd5b6001600160a01b03811660009081526003602052604090206001015460ff16156107a1576040805162461bcd60e51b815260206004820152601860248201527f54686520766f74657220616c726561647920766f7465642e0000000000000000604482015290519081900360640190fd5b6001600160a01b038116600090815260036020526040902054156107c457600080fd5b6001600160a01b0316600090815260036020526040902060019055565b600360205260009081526040902080546001820154600290920154909160ff8116916101009091046001600160a01b03169084565b60006004610822610625565b8154811061082c57fe5b90600052602060002090600202016000015490509056fe4f6e6c79206368616972706572736f6e2063616e20636c6f736520656c656374696f6e2e4f6e6c79206368616972706572736f6e2063616e206769766520726967687420746f20766f74652ea265627a7a7231582045e85f7240be9cf1692b019fb265b42aa108321a708a617de1363e0f6663859964736f6c634300050c0032";

    public static final String FUNC_CHAIRPERSON = "chairperson";

    public static final String FUNC_CLOSE = "close";

    public static final String FUNC_DELEGATE = "delegate";

    public static final String FUNC_GIVERIGHTTOVOTE = "giveRightToVote";

    public static final String FUNC_INPROGRESS = "inProgress";

    public static final String FUNC_NUMBERPROPOSALS = "numberProposals";

    public static final String FUNC_PROPOSALS = "proposals";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_VOTERS = "voters";

    public static final String FUNC_WINNERNAME = "winnerName";

    public static final String FUNC_WINNINGPROPOSAL = "winningProposal";

    @Deprecated
    protected Ballot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ballot(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ballot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<String> chairperson() {
        final Function function = new Function(FUNC_CHAIRPERSON, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> close() {
        final Function function = new Function(
                FUNC_CLOSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> delegate(String to) {
        final Function function = new Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> giveRightToVote(String voter) {
        final Function function = new Function(
                FUNC_GIVERIGHTTOVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(voter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> inProgress() {
        final Function function = new Function(FUNC_INPROGRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> numberProposals() {
        final Function function = new Function(FUNC_NUMBERPROPOSALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<byte[], BigInteger>> proposals(BigInteger param0) {
        final Function function = new Function(FUNC_PROPOSALS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<byte[], BigInteger>>(
                new Callable<Tuple2<byte[], BigInteger>>() {
                    @Override
                    public Tuple2<byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger proposal) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>> voters(String param0) {
        final Function function = new Function(FUNC_VOTERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>>(
                new Callable<Tuple4<BigInteger, Boolean, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, Boolean, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, Boolean, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<byte[]> winnerName() {
        final Function function = new Function(FUNC_WINNERNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> winningProposal() {
        final Function function = new Function(FUNC_WINNINGPROPOSAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ballot(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ballot(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
