# Blockchain based Distributed Voting System
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)


A Blockchain based secure voting system with delegation support.
  
## Special Features
* Clean Interface for both Election Chairperson and Voters.
* Support for delegation.

## Screenshots
#### Chairman's Panel
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/ChairmanPanel.png?raw=true)

#### Election Manager
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/ManageElection.png?raw=true)

#### Authorize Voter
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/AuthorizeVoter.png?raw=true)

#### Voter's Panel
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/Vote.png?raw=true)

#### Give Vote
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/VoteHelper.jpg?raw=true)

#### Delegate Vote
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/Delegator.png?raw=true)

#### View Results on election ending
![Screenshot](https://raw.githubusercontent.com/nisiddharth/Blockchain-Voting-System/master/Screenshots/ViewResult.jpg?raw=true)

## To use
   * Make sure JDK 1.8 is installed on your system and added to System `PATH`.
   * Install [Ganache](https://www.trufflesuite.com/ganache) on your system (It provides a one-click personal Ethereum blockchain).
   * Run Ganache on Port number `8545`, leave other settings at their defaut.
   * Clone this git repository using
     ```
     git clone https://github.com/nisiddharth/Blockchain-Voting-System.git
     ```
   * Open project folder in `NetBeans IDE 8.2 or above`, configure library paths according to your system. All required libraries are present in `./required_jars` directory.
   * Build project and run `voting.system.ChairmanPanel` to start Election process, and `voting.voter.Vote` to Vote.
   * At end of Election, press 'End Election and view Result' button to view Results.

## Library Used
  * [Web3j](https://github.com/web3j/web3j) -  Java and Android library for integration with Ethereum clients

## Tools Used
   * [Solidity compiler](https://github.com/ethereum/solidity/releases/download/v0.5.12/solidity-windows.zip)
   * [Web3j command line client](https://github.com/web3j/web3j/releases/tag/v3.6.0)
   * [Ganache](https://www.trufflesuite.com/ganache)
   * [NetBeans 12.2 IDE](https://netbeans.apache.org/)
   * [Remix IDE](http://remix.ethereum.org/)
