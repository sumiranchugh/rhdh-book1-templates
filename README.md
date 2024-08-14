# RHDH Software Templates for the Book "Prepare to Perform"

Instead of directly using this repository for working with the book's example, please create your own fork first. In the forked repository, make the necessary cluster specific changes using the provided GitHub Action before finally adding the templates to your Red Hat Developer Hub instance.

### 1. Create your fork

From the menu bar in the top right choose the **Fork** button.

![fork repo](docs/images/01_fork_repo.png)

In the fork dialog choose where (i.e. Owner) your forked repository should be stored and what name it should get. Confirm by clicking the **Create fork** button.

![create fork dialog](docs/images/02_create_fork_dialog.png)

Eventually, you'll end up in the main overview page of your forked repository. 

![forked repo overview](docs/images/03_forked_repo_overview.png)

### 2. Run the Github Action

Choose the Actions tab from the top menu bar. Since this repository contains a workflow file you need to explicitly **enable workflows** in your fork by clicking the corresponding button.

![forked repo enable github actions](docs/images/04_forked_repo_gh_actions_enable.png)

This brings you directly to the Workflow overview page. Choose **adapt-cluster-id** from the left navigation and then click the **Run workflow** drop-down on the far right.

![forked repo github actions](docs/images/06_forked_repo_run_workflow_1.png)

In that dialog, **specify the cluster id** for your RHDH instance. The format varies but it could look like this: *.apps.cluster-hhlrf.sandbox1697.opentlc.com*

![forked repo run workflow](docs/images/07_forked_repo_run_workflow_2.png)

Confirm by clicking the **Run workflow** button. This will queue a new workflow run which will get started soon and is expected to finish successfully within just a few moments.

![forked repo workflow success](docs/images/10_forked_repo_run_workflow_success.png)

Behind the scences, this workflow run automatically patched the cluster id across all four software templates used in the book's examples. You can see the results as part of a new commit on the main branch in your forked repository.

![forked repo workflow results 1](docs/images/11_forked_repo_workflow_results_1.png)

![forked repo workflow results 2](docs/images/12_forked_repo_workflow_results_2.png)

### 3. Add the software templates

After these preparations, you can proceed with the steps in the book in _"Chapter 3: Templates - Application head start"_ at the section _"Template registration"_.

test