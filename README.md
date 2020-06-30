# jboss-identity-example
Jboss application with Jboss identity

#### This article is originaly created by [aamonten](https://developer.jboss.org/people/aamonten) on [Quick start with JBoss Identity Federation & JBoss Application Server 4.2.3](https://developer.jboss.org/docs/DOC-13422)

This article explains how to build a single sign on (SSO) environment using the new JBoss Identity Federation Project. In the example there will be two Service Providers and one Identity Provider all running on one server (laptop in my case). The test application is the one normally used to test JBoss Federated Single Sign On (SSO), so most of the functionalities wont work, but is enough to test the SSO login.

- Downloading [JBoss Application Server 5.1.0.GA](https://sourceforge.net/projects/jboss/files/JBoss/JBoss-5.1.0.GA/jboss-5.1.0.GA.zip/download)

- Extract the downloaded file, the directory created will be the JBOSS_HOME.

- Download [Jboss identity](http://repository.jboss.org/maven2/org/jboss/identity/jboss-identity-platform-jbas/1.0.0.alpha2/jboss-identity-platform-jbas-1.0.0.alpha2.zip)

- Download [test.war](https://developer.jboss.org/servlet/JiveServlet/download/13422-4-6227/test.war) and [idp.war](https://developer.jboss.org/servlet/JiveServlet/download/13422-4-6228/idp.war) to create environments

```
wget https://developer.jboss.org/servlet/JiveServlet/download/13422-4-6227/test.war && 
wget https://developer.jboss.org/servlet/JiveServlet/download/13422-4-6228/idp.war
```

- Edit your /etc/hosts file (on linux) to resolve some domains for different local ip addresses

```
127.0.50.1 node1.jboss.com
127.0.51.1 node2.jboss.com
127.0.52.1 fedserver.jboss.com
```

- Reset your network interface

```
sudo ifconfig eth0 down && sudo ifconfig eth0 up
```

- Obs.: If you don't know what is your network interface

```
ifconfig -a
```

- Create profiles for each component of the Single Sign On environment at $JBOSS_HOME/server

```
cp -rf default idp (Identity Provider)
cp -rf default sp1 (Service Provider)
cp -rf default sp2 (Service Provider)
```

- Copy the jars inside Jboss Identity to lib of each service

```
cp *.jar JBOSS_HOME/server/sp1/lib
cp *.jar JBOSS_HOME/server/sp2/lib
cp *.jar JBOSS_HOME/server/idp/lib
```

- modify the file:
JBOSS_HOME/server/sp2/deploy/test.war/WEB-INF/jboss-idfed.xml
```
change line 
<ServiceURL>http://node1.jboss.com:8080/test</ServiceURL>
for
<ServiceURL>http://node2.jboss.com:8080/test</ServiceURL>
```

- Now, start each component of the environment
```
JBOSS_HOME/bin/run.sh -c sp1 -b node1.jboss.com
JBOSS_HOME/bin/run.sh -c sp2 -b node2.jboss.com
JBOSS_HOME/bin/run.sh -c idp -b fedserver.jboss.com
```

Access to [node1.jboss.com](http://node1.jboss.com:8080) and make the login with credentials user: admin password: admin then switch to [node2.jboss.com](http://node2.jboss.com:8080) and try to do again a login, you will notice that you are already logged in.

For information about the content and configuration of idp.war and test.war please take a look at the [Identity Federation Documentation](https://docs.jboss.org/jbossidentity/docs/guides/identity-fed/UserGuide/html/index.html)
