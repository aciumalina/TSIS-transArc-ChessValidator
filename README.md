# ChessPositionValidator – Running ArDoCo (ICSE’24)

This repository demonstrates how to run the **[ArDoCo](https://github.com/ardoco) (ICSE 2024) traceability recovery model** on the *ChessPositionValidator* sample project in order to recover trace links between **software architecture documentation (SAD)** and **source code**.

The experiment focuses on the **SAD–Code** traceability scenario and evaluates the results against manually created gold standards.

---

## Prerequisites

Before starting, ensure that the following tools are installed:

- **Git**
- **Docker**

> All ArDoCo-related tools are executed inside a Docker container.

---

## Project Setup

### 1. Clone the repository

```bash
git clone https://github.com/aciumalina/TSIS-transArc-ChessValidator
cd TSIS-transArc-ChessValidator
```

### 2. Pull the ArDoCo Docker Image

```bash
docker pull ghcr.io/ardoco/icse24
```
The image includes:
 - a precompiled ArDoCo CLI
 - required NLP and traceability models
 - evaluation tools

### 3.Start an interactive Docker container and mount the project directory
```bash
docker run -it --rm \
  -v <your local filesystem path>/TSIS-transArc-ChessValidator/:/workspace/project \
  ghcr.io/ardoco/icse24 /bin/bash
```

### 4. Recover SAD–Code trace links (high-level)

```bash
cd ardoco+arcotl

java -jar ardoco-cli.jar \
  -t SAD-Code \
  -n ChessValidator \
  -d /workspace/project/transArc/SAD/SAD_highlevel.txt \
  -m /workspace/project/transArc/SAM/SAM_chessValidator.repository \
  -c /workspace/project/src/main/java \
  -o /workspace/project/transArc/output
```
- -t `SAD-Code` selects the SAD–Code traceability task

- -n specifies the project name

- -d points to the high-level SAD document

- -m specifies the SAM model

- -c points to the Java source code

- -o specifies the output directory

> The recovered trace links are written to transArc/output/sadCodeTlr_ChessValidator.csv

### 5. Evaluate SAM–Code trace links

```bash
java -jar ../evaluator/evaluator.jar \
  -t /workspace/project/transArc/output/samCodeTlr_ChessValidator.csv \
  -g /workspace/project/transArc/goldenStandards/goldstandard_samCode.csv
```

> The evaluator reports precision, recall, and F1-score.

### 6. Recover SAD–Code trace links (detailed version)

```bash
java -jar ardoco-cli.jar \
  -t SAD-Code \
  -n ChessValidator \
  -d /workspace/project/transArc/SAD/SAD_detailed.txt \
  -m /workspace/project/transArc/SAM/SAM_chessValidator.repository \
  -c /workspace/project/src/main/java \
  -o /workspace/project/transArc/output
```

### 7. Evaluate SAD–Code trace links (detailed version)

```bash
java -jar ../evaluator/evaluator.jar \
  -t /workspace/project/transArc/output/sadCodeTlr_ChessValidator.csv \
  -g /workspace/project/transArc/goldenStandards/goldstandard_detailed_sadCode.csv
```