# Quick Start: Publishing to Maven Central

Quick reference for publishing JQuantitor after initial setup is complete.

## Prerequisites Checklist

- [ ] Sonatype JIRA account created
- [ ] JIRA ticket approved for `io.github.gcng54` groupId
- [ ] GPG key generated and published to key servers
- [ ] `~/.m2/settings.xml` configured with credentials

## Publishing Commands

```bash
# 1. Build and test locally
mvn clean package -Prelease -Dgpg.skip=true

# 2. Deploy to staging
mvn clean deploy -Prelease

# 3. Release via Web UI
# Visit: https://s01.oss.sonatype.org/
# - Login
# - Staging Repositories → Select your repo
# - Click "Close" → Wait for validation
# - Click "Release"
```

## Version Release Workflow

```bash
# 1. Update version (remove -SNAPSHOT)
# Edit: pom.xml and Quantitor/pom.xml

# 2. Commit and tag
git add pom.xml Quantitor/pom.xml
git commit -m "Release version X.Y.Z"
git tag -a vX.Y.Z -m "Release version X.Y.Z"

# 3. Deploy
mvn clean deploy -Prelease

# 4. Release (via web UI or automatic)

# 5. Push tags
git push origin main --tags

# 6. Bump to next SNAPSHOT version
# Edit: pom.xml and Quantitor/pom.xml
git add pom.xml Quantitor/pom.xml
git commit -m "Bump to next development version"
git push origin main
```

## Current Configuration

**GroupId**: `io.github.gcng54`  
**ArtifactId**: `Quantitor`  
**Version**: `0.1.1`  
**Repository**: https://github.com/gcng54/JEvaluator

## Usage in Other Projects

```xml
<dependency>
    <groupId>io.github.gcng54</groupId>
    <artifactId>Quantitor</artifactId>
    <version>0.1.1</version>
</dependency>
```

For complete instructions, see [PUBLISHING.md](PUBLISHING.md).
