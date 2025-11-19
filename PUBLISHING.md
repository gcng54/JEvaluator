# Publishing JQuantitor to Maven Central

This guide will walk you through the complete process of publishing the JQuantitor package to Maven Central.

## Overview

Maven Central is the primary repository for distributing Java libraries. Publishing to Maven Central allows other developers to easily include your library as a dependency in their projects.

## Prerequisites

Before you can publish to Maven Central, you need to complete several setup steps:

### 1. Create a Sonatype JIRA Account

1. Go to https://issues.sonatype.org/secure/Signup!default.jspa
2. Create an account
3. Verify your email address

### 2. Create a JIRA Ticket to Claim Your GroupId

1. Log into https://issues.sonatype.org
2. Create a new ticket (Create button at the top)
3. Select **Project**: Community Support - Open Source Project Repository Hosting (OSSRH)
4. Select **Issue Type**: New Project
5. Fill in the following details:
   - **Summary**: Request for io.github.gcng54 groupId
   - **Description**: Request to publish JQuantitor and other Java libraries
   - **Group Id**: `io.github.gcng54`
   - **Project URL**: https://github.com/gcng54/JEvaluator
   - **SCM URL**: https://github.com/gcng54/JEvaluator.git
   - **Username(s)**: Your Sonatype username
6. Submit the ticket

**Note**: Since you're using `io.github.gcng54`, you'll need to prove ownership by:
- Creating a public repository at https://github.com/gcng54 (which you already have)
- OR adding a TXT record to your DNS if using a custom domain

Sonatype will verify your ownership and approve your ticket (usually within 2 business days).

### 3. Generate GPG Keys

Maven Central requires all artifacts to be signed with GPG. Here's how to set it up:

#### Install GPG

**On macOS:**
```bash
brew install gnupg
```

**On Ubuntu/Debian:**
```bash
sudo apt-get install gnupg
```

**On Windows:**
Download from https://www.gnupg.org/download/

#### Generate Your Key

```bash
# Generate a new GPG key pair
gpg --gen-key

# Follow the prompts:
# - Select RSA and RSA (default)
# - Key size: 2048 or 4096 bits
# - Key expires: 0 (doesn't expire) or choose a date
# - Enter your name and email (use the same email as your Git commits)
# - Enter a secure passphrase (IMPORTANT: remember this!)
```

#### List Your Keys

```bash
# List your keys to get the key ID
gpg --list-keys

# Output will look like:
# pub   rsa2048 2025-11-19 [SC]
#       ABCD1234EFGH5678IJKL9012MNOP3456QRST7890
# uid           [ultimate] Your Name <your.email@example.com>
# sub   rsa2048 2025-11-19 [E]
```

The long string (40 characters) is your key ID. You'll need the last 8 characters.

#### Publish Your Public Key

```bash
# Publish to multiple key servers for redundancy
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID
gpg --keyserver keys.openpgp.org --send-keys YOUR_KEY_ID
gpg --keyserver pgp.mit.edu --send-keys YOUR_KEY_ID
```

**Note**: Replace `YOUR_KEY_ID` with your actual 8-character key ID.

### 4. Configure Maven Settings

Create or edit `~/.m2/settings.xml` with your Sonatype credentials:

```xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>YOUR_SONATYPE_USERNAME</username>
      <password>YOUR_SONATYPE_PASSWORD</password>
    </server>
  </servers>

  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <gpg.executable>gpg</gpg.executable>
        <gpg.passphrase>YOUR_GPG_PASSPHRASE</gpg.passphrase>
      </properties>
    </profile>
  </profiles>
</settings>
```

**Security Best Practice**: Consider using Maven's password encryption:
```bash
# Generate master password
mvn --encrypt-master-password YOUR_MASTER_PASSWORD

# Create ~/.m2/settings-security.xml with:
<settingsSecurity>
  <master>{ENCRYPTED_MASTER_PASSWORD}</master>
</settingsSecurity>

# Encrypt your Sonatype password
mvn --encrypt-password YOUR_SONATYPE_PASSWORD

# Use the encrypted password in settings.xml
```

## Project Configuration (Already Done)

The following configuration has already been added to the project's POM files:

### Parent POM (pom.xml)

✅ **Metadata** - Required information about the project:
- Name, description, URL
- License information (MIT License)
- Developer information
- SCM (Source Code Management) details

✅ **Distribution Management** - Where to deploy the artifacts:
- Snapshot repository: `https://s01.oss.sonatype.org/content/repositories/snapshots`
- Release repository: `https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/`

✅ **Build Plugins**:
- `maven-source-plugin` - Generates source JAR
- `maven-javadoc-plugin` - Generates Javadoc JAR
- `maven-gpg-plugin` - Signs artifacts with GPG
- `nexus-staging-maven-plugin` - Handles deployment to Maven Central

✅ **Release Profile** - Activates all plugins when building for release

### Module POM (Quantitor/pom.xml)

✅ **Module-specific metadata**:
- Name: JQuantitor
- Description of the library

## Publishing Process

Once you've completed all prerequisites, follow these steps to publish:

### 1. Verify Your Build

First, ensure everything builds correctly:

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Build with release profile (without signing)
mvn clean package -Prelease -Dgpg.skip=true
```

This should generate three JARs for the Quantitor module:
- `Quantitor-0.1.1.jar` (main artifact)
- `Quantitor-0.1.1-sources.jar` (source code)
- `Quantitor-0.1.1-javadoc.jar` (API documentation)

### 2. Deploy Snapshot (Optional but Recommended)

Before releasing, you can deploy a snapshot version for testing:

```bash
# Make sure your version ends with -SNAPSHOT in pom.xml
# e.g., <version>0.1.1-SNAPSHOT</version>

# Deploy snapshot
mvn clean deploy -Prelease
```

Snapshots are deployed to `https://s01.oss.sonatype.org/content/repositories/snapshots/io/github/gcng54/Quantitor/`

### 3. Prepare for Release

Before releasing, ensure:

1. ✅ All tests pass
2. ✅ Version number is correct (not a SNAPSHOT)
3. ✅ Documentation is up to date
4. ✅ CHANGELOG is updated (if you have one)
5. ✅ All changes are committed to Git

### 4. Deploy to Maven Central

```bash
# Deploy to Maven Central staging repository
mvn clean deploy -Prelease
```

This command will:
1. Compile your code
2. Run tests
3. Generate source and javadoc JARs
4. Sign all artifacts with your GPG key
5. Upload to Sonatype's staging repository

**Enter your GPG passphrase when prompted.**

### 5. Release from Staging

After deployment, you need to release from the staging repository:

#### Option A: Manual Release via Web UI

1. Go to https://s01.oss.sonatype.org/
2. Log in with your Sonatype credentials
3. Click on "Staging Repositories" in the left menu
4. Find your repository (should be at the bottom, named like `iogithubgcng54-XXXX`)
5. Select it and review the contents
6. Click "Close" button (this validates the repository)
   - Wait for validation to complete (can take a few minutes)
   - If validation fails, fix the issues and deploy again
7. Once closed successfully, click "Release" button
8. Your artifacts will be published to Maven Central

#### Option B: Automatic Release (Configure in POM)

To enable automatic release, change in parent pom.xml:
```xml
<autoReleaseAfterClose>true</autoReleaseAfterClose>
```

Then deployment will automatically close and release if validation passes.

### 6. Wait for Sync

After releasing:
- Your artifacts will appear in Maven Central within **2 hours**
- Full search indexing takes about **4 hours**

You can check the status at:
- https://repo1.maven.org/maven2/io/github/gcng54/Quantitor/
- https://central.sonatype.com/artifact/io.github.gcng54/Quantitor

### 7. Verify Publication

Once synced, verify your artifact is available:

```bash
# Search on Maven Central
# Visit: https://search.maven.org/search?q=g:io.github.gcng54

# Test dependency in a new project
```

Add to another project's `pom.xml`:
```xml
<dependency>
    <groupId>io.github.gcng54</groupId>
    <artifactId>Quantitor</artifactId>
    <version>0.1.1</version>
</dependency>
```

## Using the Published Library

After successful publication, users can add JQuantitor to their projects:

### Maven

```xml
<dependency>
    <groupId>io.github.gcng54</groupId>
    <artifactId>Quantitor</artifactId>
    <version>0.1.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.gcng54:Quantitor:0.1.1'
```

### Gradle (Kotlin DSL)

```kotlin
implementation("io.github.gcng54:Quantitor:0.1.1")
```

## Releasing New Versions

When you want to release a new version:

1. **Update version numbers** in both `pom.xml` files:
   ```xml
   <version>0.1.2</version>
   ```

2. **Update documentation** (README, CHANGELOG, etc.)

3. **Commit changes**:
   ```bash
   git add pom.xml Quantitor/pom.xml README.md
   git commit -m "Bump version to 0.1.2"
   git tag -a v0.1.2 -m "Release version 0.1.2"
   git push origin main --tags
   ```

4. **Deploy**:
   ```bash
   mvn clean deploy -Prelease
   ```

5. **Release** from staging repository (via web UI or automatic)

## Troubleshooting

### Common Issues

#### "401 Unauthorized" Error
- Check your credentials in `~/.m2/settings.xml`
- Verify your Sonatype account is active
- Ensure your JIRA ticket was approved

#### GPG Signing Fails
- Make sure GPG is installed: `gpg --version`
- Verify your key exists: `gpg --list-keys`
- Check your passphrase is correct
- On Mac, you might need: `export GPG_TTY=$(tty)`

#### "Failed to validate POM" Error
- Ensure all required metadata is present (name, description, url, licenses, developers, scm)
- Check that source and javadoc JARs are generated
- Verify all artifacts are signed

#### "Repository does not allow updating" Error
- You're trying to re-deploy the same version
- Delete from staging and deploy again, or bump the version

#### Key Server Issues
- Try multiple key servers
- Wait a few minutes after uploading keys
- Use `--verbose` flag to see detailed errors

### Getting Help

- **Sonatype Support**: https://central.sonatype.org/support/
- **OSSRH Guide**: https://central.sonatype.org/publish/publish-guide/
- **Maven GPG Plugin**: https://maven.apache.org/plugins/maven-gpg-plugin/

## Summary of Changes Made

This guide includes all the Maven Central configuration that has been added to your project:

### pom.xml (Parent)
- Project metadata (name, description, URL)
- License (MIT)
- Developer information
- SCM connection details
- Distribution management for Sonatype
- Plugin configuration for:
  - Source JAR generation
  - Javadoc JAR generation
  - GPG artifact signing
  - Nexus staging/deployment
- Release profile that activates all publishing plugins

### Quantitor/pom.xml (Module)
- Module-specific name and description
- Inherits all configuration from parent

### Java Version
- Updated from Java 25 to Java 17 for compatibility
- Fixed switch statement syntax for Java 17

## Next Steps

1. ✅ Complete the prerequisites (Sonatype account, JIRA ticket, GPG keys)
2. ✅ Configure your Maven settings file
3. ✅ Test the build locally with `mvn clean package -Prelease -Dgpg.skip=true`
4. ✅ Deploy to Maven Central with `mvn clean deploy -Prelease`
5. ✅ Release from the staging repository
6. ✅ Wait for sync and verify publication

Good luck with your publication! 🚀
