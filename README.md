
[![Build Status](https://travis-ci.com/dynamicreports/dynamicreports.svg?branch=master)](https://travis-ci.com/dynamicreports/dynamicreports)

# Dynamic Reports
DynamicReports is an open source Java reporting library based on JasperReports.
It allows to create dynamic report designs and it doesn't need a visual report designer.
You can very quickly create reports and produce documents that can be displayed, printed
or exported into many popular formats such as PDF, Excel, Word and others.
<br>
The original source code was first hosted on [sourceforge](https://sourceforge.net/p/dynamicreports) and
interactions were carried out through [dynamicreports.org](http://www.dynamicreports.org/). After
using this project and libraries, we the maintainers felt compelled to support the development for it has
been a great tool. However the source code has not been easily accessible and the original hosting website
on which this project was first created is no longer responsive and we do not want to see a great project
go down and disappear like that.
<br>
#### Project Goals
This project aims to maintain the original source code of the same using familiar tools,
like maven in a way that is accessible to allow contributions. It is based on version 5.1.0 of dynamic reports
and Jasper Reports version 6.5.1. We are not trying to rewrite the whole thing, but rather to enhance that which
is a already a great work.
These are the main goals of the project
- Make the source code easily accessible and assessable
- Enhance the build tools. Not to replace maven, but to make it possible to rebuild the project and all
  artifacts from a local machine
- Upgrade dependencies. The project works, but could still have more features, one was to include latest
  open source tools available
- In order to support the former, we need to first increase out test coverage to make sure nothing breaks
- Create a wiki with comprehensive explanations and illustrations on the usage of the library
- Enhance the documentation in the source code that would make the user clear on what the library is trying to
  do

#### Project Dependencies
A few tools merit to be mentioned:
 - Versioning : git
 - Build Tool : maven
 - CI : [Travis](https://travis-ci.com/dynamicreports/dynamicreports) (yet to fully setup)
 - Java version: ... (to be discussed, but minimum can be expected to be java version 8. For now).
 - Code style: [google](https://google.github.io/styleguide/javaguide.html). Enforced by checkstyle. (Setting
 that up too)

#### Contributing

See [CONTRIBUTING](.github/CONTRIBUTING.md)

### Raising Issues or bug reports
Before submitting a bug report see this [guideline](.github/CONTRIBUTING.md/#before-submitting-a-bug-report) and be sure
to follow this [approach](.github/CONTRIBUTING.md/#how-do-i-submit-a-good-bug-report) with as many details as possible.
and fill out the issue [template](.github/ISSUE_TEMPLATE.md)

#### Rules for Mergeable PRs
This is a young project and we would like it to continue to grow, and because of that, kindly be gentle and
understanding when it seems like the maintainers are just making stuff up as they go:
- The [travis](https://github.com/dynamicreports/dynamicreports/blob/master/.travis.yml) build must run successfully.
- The PR must have test cases and must not reduce the code coverage (That needs to be setup)
- The PR adheres to the template [provided](https://github.com/dynamicreports/dynamicreports/blob/master/.github/CONTRIBUTING.md)
- Watch this space :)

