## Protobuf用法

1. 訂好proto規格
2. 產出對應的Java
	* 第一種方法 Command Line 
		1. [下載protoc](https://github.com/protocolbuffers/protobuf/releases)
		2. `protoc -I={放proto的資料夾} --java_out={產出的Java路徑} {proto檔名}`
	* 第二種方法 Maven
		1. 把proto檔放在src/main/proto下 (自己建資料夾)
		2. 引入依賴
			```
			<build>
				<extensions>
					<extension>
						<groupId>kr.motd.maven</groupId>
						<artifactId>os-maven-plugin</artifactId>
						<version>1.5.0.Final</version>
					</extension>
				</extensions>
				<plugins>
					<plugin>
						<groupId>org.xolstice.maven.plugins</groupId>
						<artifactId>protobuf-maven-plugin</artifactId>
						<version>0.5.1</version>
						<extensions>true</extensions>
						<configuration>
							<protocArtifact>com.google.protobuf:protoc:${protobuf.version}:exe:${os.detected.classifier}</protocArtifact>
						</configuration>
						<executions>
							<execution>
								<goals>
									<goal>compile</goal>
									<goal>test-compile</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
			```
		3. `mvn protobuf:compile`
		4. target/generated-sources/protobuf/java 裡面可以找到生成好的Java檔
		