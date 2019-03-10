Strust2 官方教程学习：
[link](https://struts.apache.org/primer.html)
## The Apache Struts web framework
The Apache Struts web framework is a free open-source solution for creating Java web applications.

Web applications differ from conventional websites in that web applications can create a dynamic response. Many websites deliver only static pages. A web application can interact with databases and business logic engines to customize a response.

Web applications based on JavaServer Pages sometimes commingle database code, page design code, and control flow code. In practice, we find that unless these concerns are separated, larger applications become difficult to maintain.

One way to separate concerns in a software application is to use a Model-View-Controller (MVC) architecture. The Model represents the business or database code, the View represents the page design code, and the Controller represents the navigational code. The Struts framework is designed to help developers create web applications that utilize a MVC architecture.

**The framework provides three key components**:

A **“request” handler** provided by the application developer that is mapped to a standard URI. A **“response” handler** that transfers control to another resource which completes the response. A **tag library**(?) that helps developers create interactive form-based applications with server pages. The framework’s architecture and tags are buzzword compliant. Struts works well with conventional REST applications and with technologies like SOAP and AJAX.

## Key Technologies:
需要掌握的技术
### HTTP, HTML and User Agents
The World Wide Web was built over the Hypertext Transfer Protocol (HTTP) and the Hypertext Markup Language (HTML). A User Agent, like a web browser, uses HTTP to request a HTML document. The browser then formats and displays the document to its user. HTTP is used to transport more the HTML, HTML from the browser to render the view.

If you would like to learn HTML, we recommend Getting started with HTML by Dave Raggett.

### The HTTP Request/Response cycle
A very important part of HTTP for the web developer is the request/response cycle. To use HTTP you have to make a request. An HTTP server, like a web server, is then obliged to respond. When you build your web application, you design it to react to an HTTP request by returning an HTTP response. Frameworks often abstract much of these nuts and bolts, but it is important to understand what is happening behind the scenes.

If you are not familiar with the HTTP request/response you should learn about it. There is a lot of help available in the internet, like How does the Internet work?

### The Java Language and Application Frameworks
Struts is written in the Java programming language. Java is an object-orientated language, and the framework makes good use of many object-orientated techniques. A good understanding of Java, and especially object-orientated programming (OOP) and threading, will help you get the most out of Struts.

### Reflection and Introspection

Reflection is the process of determining which member fields and methods are available on an object. Introspection is a specialized form of reflection used by the JavaBean API. Using Introspection, we can determine which methods of a Object are intended to be accessed by other objects. The getters and the setters, for example.

Struts uses Introspection to convert HTTP parameters into JavaBean properties and to populate HTML fields from JavaBean properties. This technique makes it easy to “roundtrip” properties between HTML forms and JavaBeans.
Struts使用Introspection将HTTP参数转换为JavaBean属性，并从JavaBean属性填充HTML字段。这种技术使得HTML表单和JavaBeans之间的“往返”属性变得容易

While it is not necessary to have a deep understanding of these concepts when you start with Apache Struts, it will help you when your application grows and becomes more complex.

### Properties Files and ResourceBundles
Java applications, including web applications, are often configured using Properties files. Properties files are the basis for the ResourceBundles that the framework uses to provide message resources to an application.

The Java Tutorials provide a great introduction to Properties.

Java ResourceBundles use one or more Properties files to provide internationalized messages to users based their Locale. Support for localizing an application was built into the framework from the ground-up.

Again the Java Tutorials provide more information.

### Threads
With Struts 1 you were required to know a lot about how to write code which can run in a multi-threaded environment. With Struts 2 this is no longer necessary. In an Struts 2 environment each action caused by a HTTP request is a plain old Java object which is instanced for each request.

### JavaScript, AJAX, and SOAP
With HTTP and HTML you can already provide static web pages. Today this is much often not longer enough and your application users might expect a interactive user interface. Web developers often resort to JavaScript to make web applications more interesting.

AJAX is a technology often used by JavaScript programmers to create web applications that are as interactive and responsive as desktop applications. It is possible, to load a view parts of the website or just the data from the (Struts) application instead of regenerating the whole view.

Apache Struts provides plugins to easily work with AJAX and even JavaScript. Where Struts can’t provide the necessary functionality, third parties provide extensions for the required behavior.

Another technology that can enhance the HTTP request/response cycle is SOAP. Using SOAP, an application can access data and invoke business logic on another server using HTTP as transfer layer. Using AJAX and SOAP together is becoming a popular way for page to submit finely-grained requests directly to a remote server, while still retaining a separation of concerns between the the business logic and the page markup. Depending on your applications need, it might be not necessary for you to learn about SOAP.

### Servlets, Filters, and Web Containers
Since Java is an object-orientated language, the Java Servlet platform strives to cast HTTP into an object-orientated form. This strategy makes it easier for Java developers to concentrate on what they need their application to do – rather than the mechanics of HTTP.

A Java-aware HTTP server can pass a request to a servlet container. The container can fulfill the request or it can pass the request back to the HTTP server. The container decides whether it can handle the request by checking its list of servlets. If there is a servlet registered for the request, the container passes the request to the servlet.

When a request comes in, the container checks to see if there is a servlet registered for that request. If there is a match, the request is given to the servlet. If not, the request is returned to the HTTP server.

It’s the container’s job to manages the servlet lifecycle. The container creates the servlets, invokes the servlets, and ultimately disposes the servlets.

The old Struts 1 version relied heavily on servlets and good knowledge about it usually helped a lot with developing web applications.

With Struts 2, you’ll need only a basic understanding of Servlets. Struts actually uses a so called ServletFilter to "make things work". In general you are not required to write Servlets when using Struts 2. It still helps to know what Servlets, Filters and Containers are.

**Filter**
Filters let you compose a set of components that will process a request or response. Filters are aggregated into a chain in which each filter has a chance to process the request and response before and after it is processed by subsequent filters (and the servlet that is ultimately called).

### Sessions #{session}
One of the key characteristics of HTTP is that it is stateless. In other words, there is nothing built in to HTTP that identifies a subsequent request from the same user as being related to a previous request from that user. This makes building an application that wants to engage in a conversation with the user over several requests to be somewhat difficult.

To alleviate this difficulty, the servlet API provides a programmatic concept called a session, represented as an object that implements the javax.servlet.http.HttpSession interface. The servlet container will use one of two techniques (cookies or URL rewriting) to ensure that the next request from the same user will include the session id for this session, so that state information saved in the session can be associated with multiple requests. This state information is stored in session attributes (in JSP, they are known as “session scope beans”).

To avoid occupying resources indefinitely when a user fails to complete an interaction, sessions have a configurable timeout interval. If the time gap between two requests exceeds this interval, the session will be timed out, and all session attributes removed. You define a default session timeout in your web application deployment descriptor.

It is important to know that Session data most often occupies RAM memory of your server. Depending on your container you may have different options to bypass this.

Struts 2 provides easy ways to create and access a session.

### Web Applications
Just as a HTTP server can be used to host several distinct websites, a servlet container can be used to host more than one web application. The Java servlet platform provides a well-defined mechanism for organizing and deploying web applications. Each application runs in its own namespace so that they can be developed and deployed separately. A web application can be assembled into a **Web Application Archive**, or *WAR* file. The single WAR can be uploaded to the server and automatically deployed.

You definitely need to learn how you can build a war file from your Struts application and deploy it to your server. This might require knowledge of build tools like Maven and addition reading in the documentation of your server vendor

### Security
One detail that can be configured in the Web application deployment descriptor is container-managed security. Declarative security can be used to protect requests for URIs that match given patterns. Pragmatic security can be used to fine-tune security make authorization decisions based on the time of day, the parameters of a call, or the internal state of a Web component. It can also be used to restrict authentication based on information in a database.

For more about security, you should read the Java EE tutorial. Other projects, like Apache Shiro or Spring Security might also help you to secure your web application.

### Model View Controller (MVC)
Web applications based on JavaServer Pages sometimes commingle<vt. & vi. <文>混合,掺和,合并> database code, page design code, and control flow code. In practice, we find that unless these concerns are separated, larger applications become difficult to maintain.

One way to separate concerns in a software application is to use a Model-View-Controller (MVC) architecture. The Model represents the business or database code, the View represents the page design code, and the Controller represents the navigational code.

The term “MVC” originated with the SmallTalk Model-View-Controller framework. In Smalltalk MVC, the View updates itself from the Model, via the “Observer” pattern. The original MVC pattern is like a closed loop: The View talks to the Controller, which talks to the Model, which talks to the View.

But, a direct link between the Model and the View is not practical for web applications, and we modify the classic MVC arrangement so that it would look less like a loop and more like a horseshoe with the controller in the middle.

In the MVC/Model 2 design pattern, application flow is mediated<vt. 仲裁，调停；调解（mediate的过去式及过去分词形式）> by a central Controller. The Controller delegates requests - in our case, HTTP requests - to an appropriate handler. The handlers are tied to a Model, and each handler acts as an adapter between the request and the Model. The Model represents, or encapsulates, an application’s business logic or state. Control is usually then forwarded back through the Controller to the appropriate View. The forwarding can be determined by consulting a set of mappings, usually loaded from a database or configuration file. This provides a loose coupling between the View and Model, which can make applications significantly easier to create and maintain.

While MVC is a convenient paradigm<N-VAR	可变名词样板；范式 A paradigm is a model for something which explains it or shows how it can be produced.>, many workers find that applcations may utilize more than three layers. For example, within the Model, there is often distinct business logic and data access layers.

The framework provides the control layer for a Model 2 web applications. Developers can use this layer with other standard technologies to build the business, data access, and presentation layers.

For more about MVC, see

Smalltalk MVC framework.
Wikipedia - MVC