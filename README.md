
<div align="center">

 
  <h1>Easy-Returns</h1>
  
  <p>
    Return Order management Portal
  </p>
  
  
<!-- Badges -->
<p>
  <a href="https://github.com/tarunbylapudi/easy-returns/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/tarunbylapudi/easy-returns" alt="contributors" />
  </a>
  <a href="">
    <img src="https://img.shields.io/github/last-commit/tarunbylapudi/easy-returns" alt="last update" />
  </a>
  <a href="https://github.com/tarunbylapudi/easy-returns/network/members">
    <img src="https://img.shields.io/github/forks/tarunbylapudi/easy-returns" alt="forks" />
  </a>
  <a href="https://github.com/tarunbylapudi/easy-returns/stargazers">
    <img src="https://img.shields.io/github/stars/tarunbylapudi/easy-returns" alt="stars" />
  </a>
  <a href="https://github.com/tarunbylapudi/easy-returns/issues/">
    <img src="https://img.shields.io/github/issues/tarunbylapudi/easy-returns" alt="open issues" />
  </a>
  <a href="https://github.com/tarunbylapudi/easy-returns/blob/master/LICENSE">
    <img src="https://img.shields.io/github/license/tarunbylapudi/easy-returns.svg" alt="license" />
  </a>
</p>
   
<h4>
    <a href="https://github.com/tarunbylapudi/easy-returns/">View Demo</a>
  <span> · </span>
    <a href="https://github.com/tarunbylapudi/easy-returns">Documentation</a>
  <span> · </span>
    <a href="https://github.com/tarunbylapudi/easy-returns/issues/">Report Bug</a>
  <span> · </span>
    <a href="https://github.com/tarunbylapudi/easy-returns/issues/">Request Feature</a>
  </h4>
</div>

<br />

<!-- Table of Contents -->
# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
  * [Screenshots](#camera-screenshots)
  * [Tech Stack](#space_invader-tech-stack)
  * [Features](#dart-features)
  * [Color Reference](#art-color-reference)
  * [Environment Variables](#key-environment-variables)
- [Getting Started](#toolbox-getting-started)
  * [Prerequisites](#bangbang-prerequisites)
  * [Installation](#gear-installation)
  * [Running Tests](#test_tube-running-tests)
  * [Run Locally](#running-run-locally)
  * [Deployment](#triangular_flag_on_post-deployment)
- [Usage](#eyes-usage)
- [Roadmap](#compass-roadmap)
- [Contributing](#wave-contributing)
  * [Code of Conduct](#scroll-code-of-conduct)
- [FAQ](#grey_question-faq)
- [License](#warning-license)
- [Contact](#handshake-contact)
- [Acknowledgements](#gem-acknowledgements)

  

<!-- About the Project -->
## :star2: About the Project

<ul>

 <li>The application is used to create order requests and to calculate the item costs for valid users.</li>
 <li>Used Angular to develop the fronted and java, Spring Rest with Spring boot for the backend.</li>
 <li>Implemented Microservices architecture and used Feign Client for communication between microservices.</li>
 <li>To secure the application used Spring Security and jwt tokens for Authentication and Authorization.</li>
 <li>Used Junit for unit testing, Lombok to reduce boilerplate code, and Sonar lint to check code quality & code security.</li>
 <li>Used docker to generate images of microservices and deployed the application on AWS using ECR, ECS FARGATE, and implemented ci/cd using AWS code pipeline.</li>
 <li>In Angular used concepts like Guard, Interceptor, Data binding, Event binding, and Template driven forms.</li>
 </ul>


<!-- Screenshots -->
### :camera: Screenshots

![Login](https://github.com/tarunbylapudi/easy-returns/blob/main/ReadMe-assets/login.png?raw=true)
![Create-order](https://github.com/tarunbylapudi/easy-returns/blob/main/ReadMe-assets/create_order.png?raw=true)
![Process-details](https://github.com/tarunbylapudi/easy-returns/blob/main/ReadMe-assets/process_details.png?raw=true)
![Checkout](https://github.com/tarunbylapudi/easy-returns/blob/main/ReadMe-assets/checkout.png?raw=true)
![Confirmation](https://github.com/tarunbylapudi/easy-returns/blob/main/ReadMe-assets/confirmation.png?raw=true)





<!-- TechStack -->
### :space_invader: Tech Stack

<details>
  <summary>Client</summary>
  <ul>
    <li><a href="https://www.typescriptlang.org/">Typescript</a></li>
    <li><a href="https://angular.io/">Angular</a></li>
    <li><a href="https://getbootstrap.com/">Bootstrap</a></li>
    
  </ul>
</details>

<details>
  <summary>Server</summary>
 <ul>
  <li><a href="https://www.java.com/">Java</a></li>
    <li><a href="https://spring.io/projects/spring-boot">Spring-boot</a></li>
 </ul>
  
</details>

<details>
<summary>Database</summary>
  <ul>
    <li><a href="https://www.h2database.com/html/main.html">H2</a></li>
    
  </ul>
</details>

<details>
<summary>DevOps</summary>
  <ul>
    <li><a href="https://www.docker.com/">Docker</a></li>
    <li><a href="https://aws.amazon.com/console/">AWS</a></li>
    
  </ul>
</details>

<!-- Features -->
### :dart: Features

- Feature 1
- Feature 2
- Feature 3

<!-- Color Reference -->
### :art: Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Primary Color | ![#222831](https://via.placeholder.com/10/222831?text=+) #222831 |
| Secondary Color | ![#393E46](https://via.placeholder.com/10/393E46?text=+) #393E46 |
| Accent Color | ![#00ADB5](https://via.placeholder.com/10/00ADB5?text=+) #00ADB5 |
| Text Color | ![#EEEEEE](https://via.placeholder.com/10/EEEEEE?text=+) #EEEEEE |


<!-- Env Variables -->
### :key: Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`API_KEY`

`ANOTHER_API_KEY`

<!-- Getting Started -->
## 	:toolbox: Getting Started

<!-- Prerequisites -->
### :bangbang: Prerequisites

This project uses Yarn as package manager

```bash
 npm install --global yarn
```

<!-- Installation -->
### :gear: Installation

Install my-project with npm

```bash
  yarn install my-project
  cd my-project
```
   
<!-- Running Tests -->
### :test_tube: Running Tests

To run tests, run the following command

```bash
  yarn test test
```

<!-- Run Locally -->
### :running: Run Locally

Clone the project

```bash
  git clone https://github.com/Louis3797/awesome-readme-template.git
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
  yarn install
```

Start the server

```bash
  yarn start
```


<!-- Deployment -->
### :triangular_flag_on_post: Deployment

To deploy this project run

```bash
  yarn deploy
```


<!-- Usage -->
## :eyes: Usage

Use this space to tell a little more about your project and how it can be used. Show additional screenshots, code samples, demos or link to other resources.


```javascript
import Component from 'my-project'

function App() {
  return <Component />
}
```

<!-- Roadmap -->
## :compass: Roadmap

* [x] Todo 1
* [ ] Todo 2


<!-- Contributing -->
## :wave: Contributing

<a href="https://github.com/Louis3797/awesome-readme-template/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" />
</a>


Contributions are always welcome!

See `contributing.md` for ways to get started.


<!-- Code of Conduct -->
### :scroll: Code of Conduct

Please read the [Code of Conduct](https://github.com/Louis3797/awesome-readme-template/blob/master/CODE_OF_CONDUCT.md)

<!-- FAQ -->
## :grey_question: FAQ

- Question 1

  + Answer 1

- Question 2

  + Answer 2


<!-- License -->
## :warning: License

Distributed under the no License. See LICENSE.txt for more information.


<!-- Contact -->
## :handshake: Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - email@email_client.com

Project Link: [https://github.com/Louis3797/awesome-readme-template](https://github.com/Louis3797/awesome-readme-template)


<!-- Acknowledgments -->
## :gem: Acknowledgements

Use this section to mention useful resources and libraries that you have used in your projects.

 - [Shields.io](https://shields.io/)
 - [Awesome README](https://github.com/matiassingers/awesome-readme)
 - [Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md#travel--places)
 - [Readme Template](https://github.com/othneildrew/Best-README-Template)


