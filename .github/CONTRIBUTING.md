# Contributing to Dynamic Reports

:+1::tada: First off, thanks for taking the time to contribute! :tada::+1:

The following is a set of guidelines for contributing to DynamicReports,
which is hosted in the [Dynamic Reports Organization](https://github.com/dynamicreports) on GitHub.
These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to
this document in a pull request.

#### Table Of Contents

[Code of Conduct](#code-of-conduct)

[What should I know before I get started?](#what-should-i-know-before-i-get-started)
  * [Java and OOP](#java-and-oop)
  * [Apache POI Library](#apache-poi-library)
  * [Jasper Reports Library](#jasper-reports-library)
  * [xml](https://www.xml.com/pub/a/w3j/s3.walsh.html)
  * [Dynamic Reports Design Decisions](#Dynamic Reports Design Decisions)

[How Can I Contribute?](#How Can I Contribute?)
  * [Reporting Bugs](#reporting-bugs)
  * [Suggesting Enhancements](#suggesting-enhancements)
  * [Your First Code Contribution](#your-first-code-contribution)
  * [Pull Requests](#pull-requests)

[Styleguides](#styleguides)
  * [Git Commit Messages](#git-commit-messages)
  * [Java Styleguide](#Java Styleguide)
  * [XML Styleguide](#XML Styleguide)
  * [JUnit tests Styleguide](#Tests StyleGuide)
  * [Documentation Styleguide](#documentation-styleguide)

[Additional Notes](#additional-notes)
  * [Issue and Pull Request Labels](#issue-and-pull-request-labels)

## Code of Conduct

This project and everyone participating in it is governed by the [Dynamic Reports Code of Conduct](https://github.com/dynamicreports/dynamicreports/blob/master/.github/CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code.
Please report unacceptable behavior to [mailnjeru@gmail.com](mailto:mailnjeru@gmail.com).

## What should I know before I get started?

### Java and OOP
This project is largely built on java, but it contains occasional use of groovy here and there. Eloquence in famous GOF patterns is essential not only
in making the source easily maintainable and scalable but also it would enable easy comprehension and correspondence. As we go functional constructs
are also encouraged over declarative approaches, though over-use beats the purpose, that being comprehension. We would accept easily understandable
"average-performance" code, over obfuscated high-performance code any day.

### Apache POI Library
This library abstracts implementations for accessing and editing microsoft excel data, although eloquence in this library is not strictly
necessary since it is abstracted by the Jasper Reports library, it might still go a long way in understanding the internals

### Jasper Reports Library
This is a collection of libraries well known to do what this library is already doing except that this has to be done at compile time, or with
xml files.

### JAXB api
Dynamic reports behaves dynamically to the end user, but underneath all that, it uses the jasper reports engine which is static.
Inorder to adhere to its dynamic nature configurations the dynamic reports uses the JAXB api for marshalling and unmarshalling configurations
at runtime. This introduces a number of complexities which are mainly because the build could suddenly not contain the classes on 
which the api, depends. JAXB engines create classes and xml files which are not in the version control. Therefore the following conventions are encouraged:
- Before running tests in the modules other than the core module please run compilation("mvn clean compile") on the core module first
- If you are generating documentation using the "source-10" profile, also run the compilation on the core module first

### The Dynamic Reports depends on ms-fonts
This means that if you are running local builds on a linux, you will nee to install the ttf-mscorefonts-installer. If you are
using ubuntu, just run "sudo apt-get install ttf-mscorefonts-installer". Sorry linux guys

### Dynamic Reports Design Decisions

When we make a significant decision in how we maintain the project and what we can or cannot support, we will document it in the [dynamicreports/design-decisions repository](https://github.com/dynamicreports/design-decisions). If you have a question around how we do things, check to see if it is documented there.
There is an excel file in the repository, containing matters about the way forward.  However more details views of what is going
on can be accessed at the projects [page](https://github.com/dynamicreports/dynamicreports/projects)

## How Can I Contribute?

### Reporting Bugs

This section guides you through submitting a bug report for Dynamic Reports. Following these guidelines helps maintainers and the community understand your report :pencil:, reproduce the behavior :computer: :computer:, and find related reports :mag_right:.

Before creating bug reports, please check [this list](#before-submitting-a-bug-report) as you might find out that you don't need to create one. When you are creating a bug report, please [include 
as many details as possible](#How to I submit a good bug report?). Fill out [the required template](https://github.com/dynamicreports/dynamicreports/blob/master/
.github/ISSUE_TEMPLATE/standard-issue-template.md), the information it asks for helps us resolve issues faster.

> **Note:** If you find a **Closed** issue that seems like it is the same thing that you're experiencing, open a new issue and include a link to the original issue in the body of your new one.

#### Before Submitting A Bug Report

* **Check the debugging guide** (work in progress)You might be able to find the cause of the problem and fix things yourself. Most importantly, check if you can reproduce the problem in the latest version of dynamic reports, and if you can get the desired behavior by changing local build of the source code.
* **Check the FAQs on the forum** (coming soon) for a list of common questions and problems.
* **Perform a [cursory search](https://github.com/search?q=+is%3Aissue+user%3Adynamicreports)** to see if the problem has already been reported. If it has **and the issue is still open**, add a comment to the existing issue instead of opening a new one.

#### How to I submit a good bug report?

Bugs are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've done some debuging and cursory search, create an issue on the repository and provide the following information by filling in [the template](https://github.com/dynamicreports/dynamicreports/blob/master/.github/ISSUE_TEMPLATE.md).

Explain the problem and include additional details to help maintainers reproduce the problem:

* **Use a clear and descriptive title** for the issue to identify the problem.
* **Describe the exact steps which reproduce the problem** in as many details as possible. When listing steps, **don't just say what you did, but show how you did it**. For example, include a snippet of the offending code.
* **Provide specific examples to demonstrate the steps**. Include links to files or GitHub projects, or copy/pasteable snippets, which you use in those examples. If you're providing snippets in the issue, use [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines).
* **Describe the behavior you observed after following the steps** and point out what exactly is the problem with that behavior.
* **Explain which behavior you expected to see instead and why.**
* **Include screenshots and animated GIFs** which show the report generated with misaligned, or misconfigured or erroneous. If on windows 7+, we would love you to reproduce the bug, while running the problem recorder.
* **If you're reporting that dynamic reports crashed**, include a crash report with the full java stack trace from the operating system, console or IDE. Include the crash report in the issue in a [code block](https://help.github.com/articles/markdown-basics/#multiple-lines), a [file attachment](https://help.github.com/articles/file-attachments-on-issues-and-pull-requests/), or put it in a [gist](https://gist.github.com/) and provide link to that gist.
* **If the problem is related to performance or memory**, include a CPU profile capture with your report.
* **If the problem wasn't triggered by a specific action**, describe what you were doing before the problem happened and share more information using the guidelines below.

Provide more context by answering these questions:

* **Can you reproduce the problem in a different version of java runtime environment?**
* **Did the problem start happening recently** (e.g. after updating to a new version of dynamic reports) or was this always a problem?
* If the problem started happening recently, **can you reproduce the problem in an older version of dynamic reports?** What's the most recent version in which the problem doesn't happen?
* If the problem started happening recently, **Is there a library you have added to your project recently?** What is the name and version of that library, and what was it supposed to do?
* **Can you reliably reproduce the issue?** If not, provide details about how often the problem happens and under which conditions it normally happens.
* If the problem is related to working with files (e.g. opening and editing files), **does the problem happen for all files and projects or only some?** Does the problem happen only when working with local or remote files (e.g. on network drives), with files of a specific type (e.g. only excel or word files), with large files or files with very long lines, or with files in a specific encoding? Is there anything else special about the files you are using? Are they password protected? Which algorithm did you use to encrypt it?

Include details about your configuration and environment:

* **Which version of dynamic reports are you using?**
* **What's the name and version of the OS you're using**?
* **Are you running dynamic reports in a virtual machine or docker container?** If so, which VM software are you using and which operating systems and versions are used for the host and the guest?
* **Are you using dynamic reports with multiple monitors?** If so, can you reproduce the problem when you use a single monitor?
* **Which version of microsoft office were your generating?** Is it the office 2003 or 2007

### Suggesting Enhancements

This section guides you through submitting an enhancement suggestion for dynamicreports, including completely new features and minor improvements to existing functionality. Following these guidelines helps maintainers and the community understand your suggestion :pencil: and find related suggestions :mag_right:.

Before creating enhancement suggestions, please check [this list](#before-submitting-an-enhancement-suggestion) as you might find out that you don't need to create one. When you are creating an enhancement suggestion, please [include as many details as possible](#How Do I Submit A Good Enhancement Suggestion?). Fill in [the template](https://github.com/dynamicreports/dynamicreports/blob/master/.github/ISSUE_TEMPLATE.md), including the steps that you imagine you would take if the feature you're requesting existed.

#### Before Submitting An Enhancement Suggestion

* **Check the [debugging guide](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md)** for tips — you might discover that the enhancement is already available. Most importantly, check if you're using [the latest version of DynamicReports](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#update-to-the-latest-version) and if you can get the desired behavior by changing [DynamicReports' config settings](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#check-dynamicReports-settings).
* **Check if there's already [a module](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#dynamicReports-modules) which provides that enhancement.**
* **Determine [which module the enhancement should be suggested in](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#dynamicReports-modules).**
* **Perform a [cursory search](https://github.com/search?q=+is%3Aissue+user%3DynamicReports)** to see if the enhancement has already been suggested. If it has, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A Good Enhancement Suggestion?

Enhancement suggestions are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've determined [which module](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#dynamicReports-modules) your enhancement suggestion is related to, create an issue on that repository and provide the following information:

* **Use a clear and descriptive title** for the issue to identify the suggestion.
* **Provide a step-by-step description of the suggested enhancement** in as many details as possible.
* **Provide specific examples to demonstrate the steps**. Include copy/pasteable snippets which you use in those examples, as [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines).
* **Describe the current behavior** and **explain which behavior you expected to see instead** and why.
* **Include screenshots and animated GIFs** which help you demonstrate the steps or point out the part of DynamicReports which the suggestion is related to. You can use [this tool](https://www.cockos.com/licecap/) to record GIFs on macOS and Windows, and [this tool](https://github.com/colinkeenan/silentcast) or [this tool](https://github.com/GNOME/byzanz) on Linux.
* **Explain why this enhancement would be useful** to most DynamicReports users and isn't something that can or should be implemented as a [module](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#dynamicReports-modules).
* **List some other reporting libraries (in any programming language) or applications where this enhancement exists.**
* **Specify which version of DynamicReports you're using.** You can get the exact version by checking version number in the library's project's object model (pom)
* **Specify the name and version of the OS you're using.**

### Your First Code Contribution

Unsure where to begin contributing to DynamicReports? You can start by looking through these `beginner` and `help-wanted` issues:

* [Beginner issues][beginner] - issues which should only require a few lines of code, and a test or two.
* [Help wanted issues][help-wanted] - issues which should be a bit more involved than `beginner` issues.

Both issue lists are sorted by total number of comments. While not perfect, number of comments is a reasonable proxy for impact a given change will have.

If you want to read about using DynamicReports, the usage examples are available [online](https://dynamicreports.readthedocs.io/en/latest/).

#### Local development

DynamicReports Core and all packages can be developed locally. For instructions on how to do this, see the following sections in the [debugging guidelines](https://github.com/dynamicreports/dynamicreports/blob/master/.github/DEBUGGING.md#dynamicReports-local-development):

* [What I need to know before I get started](#What should I know before I get started?)
* Watch this space...

### Pull Requests

* Fill in the required [template](https://github.com/dynamicreports/dynamicreports/blob/master/.github/PULL_REQUEST_TEMPLATE.md)
* Do not include issue numbers in the PR title
* Include screenshots and animated GIFs in your pull request whenever possible.
* Follow the google java style [guide](https://google.github.io/styleguide/javaguide.html).
* Include thoughtfully-worded, well-structured unit tests folders. Run them using `mvn clean compile && mvn test`.
* Document new code based on the [Documentation Styleguide](#documentation-styleguide)
* Avoid platform-dependent code.
* Disclose the additional libraries included and make a case for them. We would like to keep this library lean.
* Place class properties in the following order:
    * Static Class methods and properties (methods or properties with `static` keyword in they signature)
    * Instance methods and properties

## StyleGuides

### Git Commit Messages

* Use the present tense ("Add feature" not "Added feature")
* Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
* Limit the first line to 72 characters or less
* Reference issues and pull requests liberally after the first line
* When only changing documentation, include `[ci skip]` in the commit title
* Consider starting the commit message with an applicable emoji:
    * :art: `:art:` when improving the format/structure of the code
    * :racehorse: `:racehorse:` when improving performance
    * :non-potable_water: `:non-potable_water:` when plugging memory leaks
    * :memo: `:memo:` when writing docs
    * :penguin: `:penguin:` when fixing something on Linux
    * :apple: `:apple:` when fixing something on macOS
    * :checkered_flag: `:checkered_flag:` when fixing something on Windows
    * :bug: `:bug:` when fixing a bug
    * :fire: `:fire:` when removing code or files
    * :green_heart: `:green_heart:` when fixing the CI build
    * :hammer: `:hammer:` when fixing the project object model configurations (pom)
    * :white_check_mark: `:white_check_mark:` when adding tests
    * :lock: `:lock:` when dealing with security
    * :arrow_up: `:arrow_up:` when upgrading dependencies
    * :arrow_down: `:arrow_down:` when downgrading dependencies
    * :shirt: `:shirt:` when removing linter warnings
    * :ship: `:ship:` when adding or removing code that could affect portability

### Java Styleguide

All Java code must adhere to google java style [guide](https://google.github.io/styleguide/javaguide.html).

### XML Styleguide
This project seeks to adhere to the google xml document format style [guide](https://google.github.io/styleguide/xmlstyle.html)

### Tests StyleGuide
Ok, that would be a bit too much, so this speaks to concept, approach and taste rather than style. [This](http://users.csc.calpoly.edu/~jdalbey/205/Resources/JUnit_Style.html) write up would be sufficiently eloquent on most matters pertaining to tests

### Documentation Styleguide

* Stick to the oracle javadoc [guidelines](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html#styleguide). Read the [documentation](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html) on javadoc tool.
As for the project wide documentation project be sure to stick to the google python style [guide](https://github.com/google/styleguide/blob/gh-pages/pyguide.md)

### Logging Style Guide
There is not an agreed upon, style-for-the-masses here, neither is this to be enforced anywhere but in the application run, as you debug this library for the purposes of sending the contributors
a bug report, or an enhancement suggestion, if there be logs, the following format is heartily encouraged : 
```
%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}
```
If that format looks familiar, :confused: it's because it is. It's the default logback configuration in :seedling: spring-boot as of version 1.5.8.RELEASE. Logs in this format are quick to triage, but if you 
know of one that is even more readable :rocket: please send us a PR on this template with the format included.

## Additional Notes
As you can see there is a lot of google style going on. That makes it easy to remember so next time you want to remember how to style up something, you simply "google" it (pun intended)

### Issue and Pull Request Labels

This section lists the labels we use to help us track and manage issues and pull requests.

[GitHub search](https://help.github.com/articles/searching-issues/) makes it easy to use labels for finding groups of issues or pull requests you're interested in. For example, you might be 
interested in [open issues across `dynamicreports/dynamicreports` and all dynamicreports repositories which are labeled as bugs, but still need to be reliably reproduced](https://github
.com/search?utf8=%E2%9C%93&q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Abug+label%3Aneeds-reproduction) or perhaps [open pull requests in `dynamicreports/dynamicreports` which haven't been 
reviewed yet](https://github.com/search?utf8=%E2%9C%93&q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+comments%3A0). To help you find issues and pull requests, each label is listed with
 search links for finding open items with that label in `dynamicreports/dynamicreports` only and also across all DynamicReports repositories. We  encourage you to read about [other search filters]
 (https://help.github.com/articles/searching-issues/) which will help you write more focused queries.

The labels are loosely grouped by their purpose, but it's not required that every issue have a label from every group or that an issue can't have more than one label from the same group.

Please open an issue on `dynamicreports/dynamicreports` if you have suggestions for new labels, and if you notice some labels are missing on some repositories, then please open an issue on that repository.

#### Type of Issue and Issue State

| Label name | `dynamic/reports` :mag_right: | `dynamicreports`‑org :mag_right: | Description |
| --- | --- | --- | --- |
| `enhancement` | [search][search-dynamicreports-repo-label-enhancement] | [search][search-dynamicreports-org-label-enhancement] | Feature requests. |
| `bug` | [search][search-dynamicreports-repo-label-bug] | [search][search-dynamicreports-org-label-bug] | Confirmed bugs or reports that are very likely to be bugs. |
| `question` | [search][search-dynamicreports-repo-label-question] | [search][search-dynamicreports-org-label-question] | Questions more than bug reports or feature requests (e.g. how do I do X). |
| `feedback` | [search][search-dynamicreports-repo-label-feedback] | [search][search-dynamicreports-org-label-feedback] | General feedback more than bug reports or feature requests. |
| `help-wanted` | [search][search-dynamicreports-repo-label-help-wanted] | [search][search-dynamicreports-org-label-help-wanted] | The DynamicReports core team would appreciate help from the community
 in resolving these issues. |
| `beginner` | [search][search-dynamicreports-repo-label-beginner] | [search][search-dynamicreports-org-label-beginner] | Less complex issues which would be good first issues to work on for users who want to contribute to DynamicReports. |
| `more-information-needed` | [search][search-dynamicreports-repo-label-more-information-needed] | [search][search-dynamicreports-org-label-more-information-needed] | More information needs to be collected about these problems or feature requests (e.g. steps to reproduce). |
| `needs-reproduction` | [search][search-dynamicreports-repo-label-needs-reproduction] | [search][search-dynamicreports-org-label-needs-reproduction] | Likely bugs, but haven't been reliably reproduced. |
| `blocked` | [search][search-dynamicreports-repo-label-blocked] | [search][search-dynamicreports-org-label-blocked] | Issues blocked on other issues. |
| `duplicate` | [search][search-dynamicreports-repo-label-duplicate] | [search][search-dynamicreports-org-label-duplicate] | Issues which are duplicates of other issues, i.e. they have been reported before. |
| `wontfix` | [search][search-dynamicreports-repo-label-wontfix] | [search][search-dynamicreports-org-label-wontfix] | The DynamicReports core team has decided not to fix these issues for now, either because they're working as intended or for some other reason. |
| `invalid` | [search][search-dynamicreports-repo-label-invalid] | [search][search-dynamicreports-org-label-invalid] | Issues which aren't valid (e.g. user errors). |

#### Topic Categories

| Label name | `dynamicreports/dynamicreports` :mag_right: | `dynamicreports`‑org :mag_right: | Description |
| --- | --- | --- | --- |
| `windows` | [search][search-dynamicreports-repo-label-windows] | [search][search-dynamicreports-org-label-windows] | Related to DynamicReports running on Windows. |
| `linux` | [search][search-dynamicreports-repo-label-linux] | [search][search-dynamicreports-org-label-linux] | Related to DynamicReports running on Linux. |
| `mac` | [search][search-dynamicreports-repo-label-mac] | [search][search-dynamicreports-org-label-mac] | Related to DynamicReports running on macOS. |
| `documentation` | [search][search-dynamicreports-repo-label-documentation] | [search][search-dynamicreports-org-label-documentation] | Related to any type of documentation (e.g. [API documentation](https://dynamicreports.io/docs/api/latest/) and the [flight manual](https://flight-manual.dynamicreports.io/)). |
| `performance` | [search][search-dynamicreports-repo-label-performance] | [search][search-dynamicreports-org-label-performance] | Related to performance. |
| `security` | [search][search-dynamicreports-repo-label-security] | [search][search-dynamicreports-org-label-security] | Related to security. |
| `ui` | [search][search-dynamicreports-repo-label-ui] | [search][search-dynamicreports-org-label-ui] | Related to visual design. |
| `api` | [search][search-dynamicreports-repo-label-api] | [search][search-dynamicreports-org-label-api] | Related to DynamicReports's public APIs. |
| `uncaught-exception` | [search][search-dynamicreports-repo-label-uncaught-exception] | [search][search-dynamicreports-org-label-uncaught-exception] | Issues about uncaught exceptions, normally created from the [Notifications package](https://github.com/dynamicreports/notifications). |
| `crash` | [search][search-dynamicreports-repo-label-crash] | [search][search-dynamicreports-org-label-crash] | Reports of DynamicReports completely crashing. |
| `encoding` | [search][search-dynamicreports-repo-label-encoding] | [search][search-dynamicreports-org-label-encoding] | Related to character encoding. |
| `network` | [search][search-dynamicreports-repo-label-network] | [search][search-dynamicreports-org-label-network] | Related to network problems or working with remote files (e.g. on network drives). |
| `git` | [search][search-dynamicreports-repo-label-git] | [search][search-dynamicreports-org-label-git] | Related to Git functionality (e.g. problems with gitignore files or with showing the correct file status). |

#### `dynamicreports/dynamicreports` Topic Categories

| Label name | `dynamicreports/dynamicreports` :mag_right: | `dynamicreports`‑org :mag_right: | Description |
| --- | --- | --- | --- |
| `editor-rendering` | [search][search-dynamicreports-repo-label-editor-rendering] | [search][search-dynamicreports-org-label-editor-rendering] | Related to language-independent aspects of rendering text (e.g. scrolling, soft wrap, and font rendering). |
| `build-error` | [search][search-dynamicreports-repo-label-build-error] | [search][search-dynamicreports-org-label-build-error] | Related to problems with building DynamicReports from source. |
| `deprecation-help` | [search][search-dynamicreports-repo-label-deprecation-help] | [search][search-dynamicreports-org-label-deprecation-help] | Issues for helping package authors remove usage of deprecated APIs in packages. |

#### Pull Request Labels

| Label name | `dynamicreports/dynamicreports` :mag_right: | `dynamicreports`‑org :mag_right: | Description
| --- | --- | --- | --- |
| `work-in-progress` | [search][search-dynamicreports-repo-label-work-in-progress] | [search][search-dynamicreports-org-label-work-in-progress] | Pull requests which are still being worked on, more changes will follow. |
| `needs-review` | [search][search-dynamicreports-repo-label-needs-review] | [search][search-dynamicreports-org-label-needs-review] | Pull requests which need code review, and approval from maintainers or DynamicReports core team. |
| `under-review` | [search][search-dynamicreports-repo-label-under-review] | [search][search-dynamicreports-org-label-under-review] | Pull requests being reviewed by maintainers or DynamicReports core team. |
| `requires-changes` | [search][search-dynamicreports-repo-label-requires-changes] | [search][search-dynamicreports-org-label-requires-changes] | Pull requests which need to be updated based on review comments and then reviewed again. |
| `needs-testing` | [search][search-dynamicreports-repo-label-needs-testing] | [search][search-dynamicreports-org-label-needs-testing] | Pull requests which need manual testing. |

[search-dynamicreports-repo-label-enhancement]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aenhancement
[search-dynamicreports-org-label-enhancement]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aenhancement
[search-dynamicreports-repo-label-bug]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Abug
[search-dynamicreports-org-label-bug]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Abug
[search-dynamicreports-repo-label-question]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aquestion
[search-dynamicreports-org-label-question]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aquestion
[search-dynamicreports-repo-label-feedback]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Afeedback
[search-dynamicreports-org-label-feedback]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Afeedback
[search-dynamicreports-repo-label-help-wanted]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Ahelp-wanted
[search-dynamicreports-org-label-help-wanted]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Ahelp-wanted
[search-dynamicreports-repo-label-beginner]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Abeginner
[search-dynamicreports-org-label-beginner]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Abeginner
[search-dynamicreports-repo-label-more-information-needed]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Amore-information-needed
[search-dynamicreports-org-label-more-information-needed]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Amore-information-needed
[search-dynamicreports-repo-label-needs-reproduction]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aneeds-reproduction
[search-dynamicreports-org-label-needs-reproduction]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aneeds-reproduction
[search-dynamicreports-repo-label-triage-help-needed]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Atriage-help-needed
[search-dynamicreports-org-label-triage-help-needed]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Atriage-help-needed
[search-dynamicreports-repo-label-windows]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Awindows
[search-dynamicreports-org-label-windows]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Awindows
[search-dynamicreports-repo-label-linux]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Alinux
[search-dynamicreports-org-label-linux]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Alinux
[search-dynamicreports-repo-label-mac]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Amac
[search-dynamicreports-org-label-mac]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Amac
[search-dynamicreports-repo-label-documentation]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Adocumentation
[search-dynamicreports-org-label-documentation]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Adocumentation
[search-dynamicreports-repo-label-performance]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aperformance
[search-dynamicreports-org-label-performance]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aperformance
[search-dynamicreports-repo-label-security]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Asecurity
[search-dynamicreports-org-label-security]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Asecurity
[search-dynamicreports-repo-label-ui]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aui
[search-dynamicreports-org-label-ui]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aui
[search-dynamicreports-repo-label-api]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aapi
[search-dynamicreports-org-label-api]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aapi
[search-dynamicreports-repo-label-crash]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Acrash
[search-dynamicreports-org-label-crash]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Acrash
[search-dynamicreports-repo-label-auto-indent]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aauto-indent
[search-dynamicreports-org-label-auto-indent]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aauto-indent
[search-dynamicreports-repo-label-encoding]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aencoding
[search-dynamicreports-org-label-encoding]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aencoding
[search-dynamicreports-repo-label-network]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Anetwork
[search-dynamicreports-org-label-network]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Anetwork
[search-dynamicreports-repo-label-uncaught-exception]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Auncaught-exception
[search-dynamicreports-org-label-uncaught-exception]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Auncaught-exception
[search-dynamicreports-repo-label-git]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Agit
[search-dynamicreports-org-label-git]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Agit
[search-dynamicreports-repo-label-blocked]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Ablocked
[search-dynamicreports-org-label-blocked]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Ablocked
[search-dynamicreports-repo-label-duplicate]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aduplicate
[search-dynamicreports-org-label-duplicate]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aduplicate
[search-dynamicreports-repo-label-wontfix]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Awontfix
[search-dynamicreports-org-label-wontfix]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Awontfix
[search-dynamicreports-repo-label-invalid]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Ainvalid
[search-dynamicreports-org-label-invalid]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Ainvalid
[search-dynamicreports-repo-label-package-idea]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Apackage-idea
[search-dynamicreports-org-label-package-idea]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Apackage-idea
[search-dynamicreports-repo-label-wrong-repo]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Awrong-repo
[search-dynamicreports-org-label-wrong-repo]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Awrong-repo
[search-dynamicreports-repo-label-editor-rendering]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aeditor-rendering
[search-dynamicreports-org-label-editor-rendering]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aeditor-rendering
[search-dynamicreports-repo-label-build-error]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Abuild-error
[search-dynamicreports-org-label-build-error]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Abuild-error
[search-dynamicreports-repo-label-error-from-pathwatcher]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aerror-from-pathwatcher
[search-dynamicreports-org-label-error-from-pathwatcher]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aerror-from-pathwatcher
[search-dynamicreports-repo-label-error-from-save]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aerror-from-save
[search-dynamicreports-org-label-error-from-save]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aerror-from-save
[search-dynamicreports-repo-label-error-from-open]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aerror-from-open
[search-dynamicreports-org-label-error-from-open]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aerror-from-open
[search-dynamicreports-repo-label-installer]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Ainstaller
[search-dynamicreports-org-label-installer]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Ainstaller
[search-dynamicreports-repo-label-auto-updater]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Aauto-updater
[search-dynamicreports-org-label-auto-updater]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aauto-updater
[search-dynamicreports-repo-label-deprecation-help]: https://github.com/search?q=is%3Aopen+is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+label%3Adeprecation-help
[search-dynamicreports-org-label-deprecation-help]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Adeprecation-help
[search-dynamicreports-repo-label-electron]: https://github.com/search?q=is%3Aissue+repo%3Adynamicreports%2Fdynamicreports+is%3Aopen+label%3Aelectron
[search-dynamicreports-org-label-electron]: https://github.com/search?q=is%3Aopen+is%3Aissue+user%3Adynamicreports+label%3Aelectron
[search-dynamicreports-repo-label-work-in-progress]: https://github.com/search?q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+label%3Awork-in-progress
[search-dynamicreports-org-label-work-in-progress]: https://github.com/search?q=is%3Aopen+is%3Apr+user%3Adynamicreports+label%3Awork-in-progress
[search-dynamicreports-repo-label-needs-review]: https://github.com/search?q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+label%3Aneeds-review
[search-dynamicreports-org-label-needs-review]: https://github.com/search?q=is%3Aopen+is%3Apr+user%3Adynamicreports+label%3Aneeds-review
[search-dynamicreports-repo-label-under-review]: https://github.com/search?q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+label%3Aunder-review
[search-dynamicreports-org-label-under-review]: https://github.com/search?q=is%3Aopen+is%3Apr+user%3Adynamicreports+label%3Aunder-review
[search-dynamicreports-repo-label-requires-changes]: https://github.com/search?q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+label%3Arequires-changes
[search-dynamicreports-org-label-requires-changes]: https://github.com/search?q=is%3Aopen+is%3Apr+user%3Adynamicreports+label%3Arequires-changes
[search-dynamicreports-repo-label-needs-testing]: https://github.com/search?q=is%3Aopen+is%3Apr+repo%3Adynamicreports%2Fdynamicreports+label%3Aneeds-testing
[search-dynamicreports-org-label-needs-testing]: https://github.com/search?q=is%3Aopen+is%3Apr+user%3Adynamicreports+label%3Aneeds-testing

[beginner]:https://github.com/search?utf8=%E2%9C%93&q=is%3Aopen+is%3Aissue+label%3Abeginner+label%3Ahelp-wanted+user%3Adynamicreports+sort%3Acomments-desc
[help-wanted]:https://github.com/search?q=is%3Aopen+is%3Aissue+label%3Ahelp-wanted+user%3Adynamicreports+sort%3Acomments-desc+-label%3Abeginner

* **Please note this guideline is borrowed from the Atom project contribution guide and still contains links to the same as it is still edits-in-progress"** *